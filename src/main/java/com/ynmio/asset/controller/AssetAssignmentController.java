package com.ynmio.asset.controller;

import com.ynmio.asset.model.AssetAssignment;
import com.ynmio.asset.service.AssetAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssetAssignmentController {

    private final AssetAssignmentService assetAssignmentService;

    @Autowired
    public AssetAssignmentController(AssetAssignmentService assetAssignmentService) {
        this.assetAssignmentService = assetAssignmentService;
    }

    @PostMapping
    public ResponseEntity<AssetAssignment> createAssignment(@RequestBody AssetAssignment assignment) {
        AssetAssignment createdAssignment = assetAssignmentService.createAssignment(assignment);
        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }

    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssetAssignment> getAssignmentById(@PathVariable Long assignmentId) {
        AssetAssignment assignment = assetAssignmentService.getAssignmentById(assignmentId);
        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    @PutMapping("/{assignmentId}")
    public ResponseEntity<AssetAssignment> updateAssignment(@PathVariable Long assignmentId, @RequestBody AssetAssignment assignment) {
        AssetAssignment updatedAssignment = assetAssignmentService.updateAssignment(assignmentId, assignment);
        return new ResponseEntity<>(updatedAssignment, HttpStatus.OK);
    }

    @DeleteMapping("/{assignmentId}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long assignmentId) {
        assetAssignmentService.deleteAssignment(assignmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<AssetAssignment>> getAllAssignments() {
        List<AssetAssignment> assignments = assetAssignmentService.getAllAssignments();
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<AssetAssignment>> getAssignmentsByPerson(@PathVariable Long personId) {
        List<AssetAssignment> assignments = assetAssignmentService.getAssignmentsByPerson(personId);
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }
}

