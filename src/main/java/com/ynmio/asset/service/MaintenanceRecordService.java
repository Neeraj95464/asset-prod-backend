package com.ynmio.asset.service;

import com.ynmio.asset.model.MaintenanceRecord;

import java.util.List;

public interface MaintenanceRecordService {
    MaintenanceRecord createMaintenanceRecord(MaintenanceRecord maintenanceRecord);
    MaintenanceRecord updateMaintenanceRecord(Long maintenanceId, MaintenanceRecord maintenanceRecord);
    void deleteMaintenanceRecord(Long maintenanceId);
    MaintenanceRecord getMaintenanceRecordById(Long maintenanceId);
    List<MaintenanceRecord> getAllMaintenanceRecords();
}

