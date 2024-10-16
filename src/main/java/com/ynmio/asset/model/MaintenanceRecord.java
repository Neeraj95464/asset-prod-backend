package com.ynmio.asset.model;

import com.ynmio.asset.model.Enum.MaintenanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance_record")
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    private LocalDateTime maintenanceDate;
    private String description;
    private double cost;
    private LocalDateTime nextDueDate;

    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status;

    // Getters and Setters
}

