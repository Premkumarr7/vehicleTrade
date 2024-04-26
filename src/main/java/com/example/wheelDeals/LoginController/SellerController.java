package com.example.wheelDeals.LoginController;

import com.example.wheelDeals.Entity.SellerEntity;
import com.example.wheelDeals.LoginService.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<SellerEntity>> getAllSellers() {
        List<SellerEntity> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/{vehicle}")
    public ResponseEntity<SellerEntity> getSellerById(@PathVariable("vehicle") String vehicle) {
        Optional<SellerEntity> seller = sellerService.getSellerById(vehicle);
        return seller.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/post")
    public ResponseEntity<SellerEntity> createSeller(@RequestBody SellerEntity sellerEntity) {
        SellerEntity createdSeller = sellerService.createSeller(sellerEntity);
        return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
    }

    @PutMapping("/{vehicle}")
    public ResponseEntity<SellerEntity> updateSeller(@PathVariable("vehicle") String vehicle,
                                                     @RequestBody SellerEntity sellerEntity) {
        SellerEntity updatedSeller = sellerService.updateSeller(vehicle, sellerEntity);
        if (updatedSeller != null) {
            return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{vehicle}")
    public ResponseEntity<Void> deleteSeller(@PathVariable("vehicle") String vehicle) {
        sellerService.deleteSeller(vehicle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
