package com.ynmio.asset.controller;

import com.ynmio.asset.model.MaintenanceRecord;
import com.ynmio.asset.service.MaintenanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRecordController {

    private final MaintenanceRecordService maintenanceRecordService;

    @Autowired
    public MaintenanceRecordController(MaintenanceRecordService maintenanceRecordService) {
        this.maintenanceRecordService = maintenanceRecordService;
    }

    @PostMapping
    public ResponseEntity<MaintenanceRecord> createMaintenanceRecord(@RequestBody MaintenanceRecord maintenanceRecord) {
        MaintenanceRecord createdRecord = maintenanceRecordService.createMaintenanceRecord(maintenanceRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{maintenanceId}")
    public ResponseEntity<MaintenanceRecord> getMaintenanceRecordById(@PathVariable Long maintenanceId) {
        MaintenanceRecord maintenanceRecord = maintenanceRecordService.getMaintenanceRecordById(maintenanceId);
        return new ResponseEntity<>(maintenanceRecord, HttpStatus.OK);
    }

    @PutMapping("/{maintenanceId}")
    public ResponseEntity<MaintenanceRecord> updateMaintenanceRecord(@PathVariable Long maintenanceId, @RequestBody MaintenanceRecord maintenanceRecord) {
        MaintenanceRecord updatedRecord = maintenanceRecordService.updateMaintenanceRecord(maintenanceId, maintenanceRecord);
        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
    }

    @DeleteMapping("/{maintenanceId}")
    public ResponseEntity<Void> deleteMaintenanceRecord(@PathVariable Long maintenanceId) {
        maintenanceRecordService.deleteMaintenanceRecord(maintenanceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRecord>> getAllMaintenanceRecords() {
        List<MaintenanceRecord> maintenanceRecords = maintenanceRecordService.getAllMaintenanceRecords();
        return new ResponseEntity<>(maintenanceRecords, HttpStatus.OK);
    }
}

