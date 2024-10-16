package com.ynmio.asset.repository;

import com.ynmio.asset.model.AssetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetCategoryRepository extends JpaRepository<AssetCategory,Long> {
}
