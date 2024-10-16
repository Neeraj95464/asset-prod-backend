package com.ynmio.asset.service;

import com.ynmio.asset.model.AssetCategory;

import java.util.List;

public interface AssetCategoryService {
    AssetCategory createCategory(AssetCategory category);
    AssetCategory updateCategory(Long categoryId, AssetCategory category);
    void deleteCategory(Long categoryId);
    AssetCategory getCategoryById(Long categoryId);
    List<AssetCategory> getAllCategories();
}

