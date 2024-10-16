package com.ynmio.asset.service;


import com.ynmio.asset.model.Asset;
import java.util.List;

public interface AssetService {
    Asset createAsset(Asset asset);
    Asset updateAsset(Long assetId, Asset asset);
    void deleteAsset(Long assetId);
    Asset getAssetById(Long assetId);
    List<Asset> getAllAssets();
    List<Asset> getAssetsByCategory(String category);
}

