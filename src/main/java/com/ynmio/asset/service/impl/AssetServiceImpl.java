package com.ynmio.asset.service.impl;

import com.ynmio.asset.model.Asset;
import com.ynmio.asset.repository.AssetRepository;
import com.ynmio.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    // not update I have to update according to model;
    @Override
    public Asset updateAsset(Long assetId, Asset asset) {
        Asset existingAsset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
        existingAsset.setName(asset.getName());
        existingAsset.setDescription(asset.getDescription());
        existingAsset.setCategory(asset.getCategory());
        existingAsset.setQuantity(asset.getQuantity());
        existingAsset.setStatus(asset.getStatus());
        existingAsset.setLocation(asset.getLocation());
        return assetRepository.save(existingAsset);
    }

    @Override
    public void deleteAsset(Long assetId) {
        Asset existingAsset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
        assetRepository.delete(existingAsset);
    }

    @Override
    public Asset getAssetById(Long assetId) {
        return assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public List<Asset> getAssetsByCategory(String category) {
        return assetRepository.findByCategory(category);
    }
}
