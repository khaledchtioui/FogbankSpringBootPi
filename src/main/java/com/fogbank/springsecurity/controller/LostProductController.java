package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.LostProduct;
import com.fogbank.springsecurity.services.LostProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lost-products")
@CrossOrigin(origins = "http://localhost:4200")

public class LostProductController {

    private final LostProductService lostProductService;

    public LostProductController(LostProductService lostProductService) {
        this.lostProductService = lostProductService;
    }
    @PostMapping("/listeLostP/{idp}/{idu}")
    @ResponseBody
    void ajouterEtaffecterListeLostProduct(@PathVariable("idp") Integer idp,@PathVariable("idu") Long idu) {
        lostProductService.ajouterEtaffecterListeLostProduct(idp, idu);
    }
    @GetMapping
    public ResponseEntity<List<LostProduct>> getAllLostProducts() {
        List<LostProduct> lostProducts = lostProductService.getAllLostProducts();
        return new ResponseEntity<>(lostProducts, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Object[]> getAllLostProduct() {
        return lostProductService.getAllLostProduct();
    }
    @PostMapping
    public ResponseEntity<LostProduct> addLostProduct(@RequestBody LostProduct lostProduct) {
        LostProduct newLostProduct = lostProductService.addLostProduct(lostProduct);
        return new ResponseEntity<>(newLostProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LostProduct> updateLostProduct(@PathVariable Integer id, @RequestBody LostProduct lostProduct) {
        lostProduct.setId(id);
        LostProduct updatedLostProduct = lostProductService.updateLostProduct(lostProduct);
        return new ResponseEntity<>(updatedLostProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLostProduct(@PathVariable Integer id) {
        lostProductService.deleteLostProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
