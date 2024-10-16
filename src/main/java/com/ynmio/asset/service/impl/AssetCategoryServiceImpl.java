package com.ynmio.asset.service.impl;

import com.ynmio.asset.model.AssetCategory;
import com.ynmio.asset.repository.AssetCategoryRepository;
import com.ynmio.asset.service.AssetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetCategoryServiceImpl implements AssetCategoryService {

    private final AssetCategoryRepository categoryRepository;

    @Autowired
    public AssetCategoryServiceImpl(AssetCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AssetCategory createCategory(AssetCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public AssetCategory updateCategory(Long categoryId, AssetCategory category) {
        AssetCategory existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        AssetCategory existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(existingCategory);
    }

    @Override
    public AssetCategory getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<AssetCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}

