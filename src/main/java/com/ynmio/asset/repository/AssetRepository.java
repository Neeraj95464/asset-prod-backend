package com.ynmio.asset.repository;

import com.ynmio.asset.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset,Long> {
    List<Asset> findByCategory(String category);
}
