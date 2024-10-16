package com.ynmio.asset.service;

import com.ynmio.asset.model.AssetAssignment;

import java.util.List;

public interface AssetAssignmentService {
    AssetAssignment createAssignment(AssetAssignment assignment);
    AssetAssignment updateAssignment(Long assignmentId, AssetAssignment assignment);
    void deleteAssignment(Long assignmentId);
    AssetAssignment getAssignmentById(Long assignmentId);
    List<AssetAssignment> getAllAssignments();
    List<AssetAssignment> getAssignmentsByPerson(Long personId);
}

