package com.ynmio.asset.repository;

import com.ynmio.asset.model.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord,Long> {
}
