package com.ynmio.asset.service.impl;

import com.ynmio.asset.model.MaintenanceRecord;
import com.ynmio.asset.repository.MaintenanceRecordRepository;
import com.ynmio.asset.service.MaintenanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    public MaintenanceRecordServiceImpl(MaintenanceRecordRepository maintenanceRecordRepository) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    @Override
    public MaintenanceRecord createMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordRepository.save(maintenanceRecord);
    }

    @Override
    public MaintenanceRecord updateMaintenanceRecord(Long maintenanceId, MaintenanceRecord maintenanceRecord) {
        MaintenanceRecord existingMaintenance = maintenanceRecordRepository.findById(maintenanceId)
                .orElseThrow(() -> new RuntimeException("Maintenance record not found"));
        existingMaintenance.setAsset(maintenanceRecord.getAsset());
        existingMaintenance.setMaintenanceDate(maintenanceRecord.getMaintenanceDate());
        existingMaintenance.setDescription(maintenanceRecord.getDescription());
        existingMaintenance.setCost(maintenanceRecord.getCost());
        existingMaintenance.setNextDueDate(maintenanceRecord.getNextDueDate());
        existingMaintenance.setStatus(maintenanceRecord.getStatus());
        return maintenanceRecordRepository.save(existingMaintenance);
    }

    @Override
    public void deleteMaintenanceRecord(Long maintenanceId) {
        MaintenanceRecord existingMaintenance = maintenanceRecordRepository.findById(maintenanceId)
                .orElseThrow(() -> new RuntimeException("Maintenance record not found"));
        maintenanceRecordRepository.delete(existingMaintenance);
    }

    @Override
    public MaintenanceRecord getMaintenanceRecordById(Long maintenanceId) {
        return maintenanceRecordRepository.findById(maintenanceId)
                .orElseThrow(() -> new RuntimeException("Maintenance record not found"));
    }

    @Override
    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return maintenanceRecordRepository.findAll();
    }
}

