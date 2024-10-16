package com.ynmio.asset.controller;

import com.ynmio.asset.model.AssetCategory;
import com.ynmio.asset.service.AssetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class AssetCategoryController {

    private final AssetCategoryService assetCategoryService;

    @Autowired
    public AssetCategoryController(AssetCategoryService assetCategoryService) {
        this.assetCategoryService = assetCategoryService;
    }

    @PostMapping
    public ResponseEntity<AssetCategory> createCategory(@RequestBody AssetCategory category) {
        AssetCategory createdCategory = assetCategoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<AssetCategory> getCategoryById(@PathVariable Long categoryId) {
        AssetCategory category = assetCategoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<AssetCategory> updateCategory(@PathVariable Long categoryId, @RequestBody AssetCategory category) {
        AssetCategory updatedCategory = assetCategoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        assetCategoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<AssetCategory>> getAllCategories() {
        List<AssetCategory> categories = assetCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}

