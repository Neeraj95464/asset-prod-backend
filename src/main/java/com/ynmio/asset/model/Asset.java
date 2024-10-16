package com.ynmio.asset.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ynmio.asset.model.Enum.AssetStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetId;
    private String name;
    private String description;
    private String category;
    private int quantity;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;
    private String model;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    @Column(name = "warranty_expiry")
    private LocalDate warrantyExpiry;
    @Enumerated(EnumType.STRING)
    private AssetStatus status;
    private Long assetPrice;

    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "asset")
    private List<AssetAssignment> assignments;

    @JsonIgnore
    @OneToMany(mappedBy = "asset")
    private List<MaintenanceRecord> maintenanceRecords;

}

