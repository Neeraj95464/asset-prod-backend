package com.ynmio.asset.service;

import com.ynmio.asset.model.Vendor;
import com.ynmio.asset.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // Create a new vendor
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Get all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Get a vendor by ID
    public Optional<Vendor> getVendorById(Long vendorId) {
        return vendorRepository.findById(vendorId);
    }

    // Update an existing vendor
    public Vendor updateVendor(Long vendorId, Vendor vendorDetails) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));

        vendor.setName(vendorDetails.getName());
        vendor.setDescription(vendorDetails.getDescription());
        vendor.setAddress(vendorDetails.getAddress());
        vendor.setCity(vendorDetails.getCity());
        vendor.setState(vendorDetails.getState());
        vendor.setCountry(vendorDetails.getCountry());
        vendor.setZipCode(vendorDetails.getZipCode());
        vendor.setPhoneNumber(vendorDetails.getPhoneNumber());
        vendor.setEmail(vendorDetails.getEmail());
        vendor.setFaxNumber(vendorDetails.getFaxNumber());
        vendor.setWebsite(vendorDetails.getWebsite());

        return vendorRepository.save(vendor);
    }

    // Delete a vendor by ID
    public void deleteVendor(Long vendorId) {
        vendorRepository.deleteById(vendorId);
    }
}

