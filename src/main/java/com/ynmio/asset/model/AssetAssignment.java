package com.ynmio.asset.model;

import java.time.LocalDate;

import com.ynmio.asset.model.Enum.AssignmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asset_assignment")
public class AssetAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    private LocalDate assignmentDate;
    private LocalDate returnDate;  // this is, I think due date;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    private String notes;

}

