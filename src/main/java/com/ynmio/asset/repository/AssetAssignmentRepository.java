package com.ynmio.asset.repository;

import com.ynmio.asset.model.AssetAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssetAssignmentRepository extends JpaRepository<AssetAssignment,Long> {

    @Query("SELECT aa FROM AssetAssignment aa WHERE aa.person.personId = :personId")
    List<AssetAssignment> findByPersonId(@Param("personId") Long personId);

}
