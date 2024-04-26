package com.example.wheelDeals.LoginService;


import com.example.wheelDeals.Entity.SellerEntity;
import com.example.wheelDeals.LoginRepository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<SellerEntity> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<SellerEntity> getSellerById(String vehicle) {
        return sellerRepository.findById(vehicle);
    }

    public SellerEntity createSeller(SellerEntity sellerEntity) {
        return sellerRepository.save(sellerEntity);
    }

    public SellerEntity updateSeller(String vehicle, SellerEntity sellerEntity) {
        if (sellerRepository.existsById(vehicle)) {
            sellerEntity.setVehicle(vehicle);
            return sellerRepository.save(sellerEntity);
        } else {
            // Handle error if seller with given ID does not exist
            return null;
        }
    }

    public void deleteSeller(String vehicle) {
        sellerRepository.deleteById(vehicle);
    }
}

