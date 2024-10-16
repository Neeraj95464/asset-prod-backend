package com.ynmio.asset.service.impl;

import com.ynmio.asset.model.Asset;
import com.ynmio.asset.model.AssetAssignment;
import com.ynmio.asset.model.Enum.AssetStatus;
import com.ynmio.asset.repository.AssetAssignmentRepository;
import com.ynmio.asset.repository.AssetRepository;
import com.ynmio.asset.service.AssetAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetAssignmentServiceImpl implements AssetAssignmentService {

    private final AssetAssignmentRepository assignmentRepository;
    private final AssetRepository assetRepository;

    @Autowired
    public AssetAssignmentServiceImpl(AssetAssignmentRepository assignmentRepository, AssetRepository assetRepository) {
        this.assignmentRepository = assignmentRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    public AssetAssignment createAssignment(AssetAssignment assignment) {
        Asset asset = assignment.getAsset();
        asset.setStatus(AssetStatus.valueOf("ASSIGNED"));
        assetRepository.save(asset);
        return assignmentRepository.save(assignment);
    }

    @Override
    public AssetAssignment updateAssignment(Long assignmentId, AssetAssignment assignment) {
        AssetAssignment existingAssignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        existingAssignment.setAsset(assignment.getAsset());
        existingAssignment.setPerson(assignment.getPerson());
        existingAssignment.setAssignmentDate(assignment.getAssignmentDate());
        existingAssignment.setReturnDate(assignment.getReturnDate());
        existingAssignment.setStatus(assignment.getStatus());
        existingAssignment.setNotes(assignment.getNotes());
        return assignmentRepository.save(existingAssignment);
    }

    @Override
    public void deleteAssignment(Long assignmentId) {
        AssetAssignment existingAssignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignmentRepository.delete(existingAssignment);
    }

    @Override
    public AssetAssignment getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public List<AssetAssignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public List<AssetAssignment> getAssignmentsByPerson(Long personId) {
        return assignmentRepository.findByPersonId(personId);
    }
}

