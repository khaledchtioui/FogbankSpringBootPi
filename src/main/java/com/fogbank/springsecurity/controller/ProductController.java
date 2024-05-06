package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.LostProduct;
import com.fogbank.springsecurity.entities.Product;
import com.fogbank.springsecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Product>> getProductsByUserId(@PathVariable Integer userId) {
        List<Product> products = productService.getProductsByUserId(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/prod/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.findProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product product1 = productService.addProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }


    @PostMapping("/prodwu/{id}")
    @ResponseBody
    void ajouterEtaffecterListeProduct(@RequestBody List<Product> lp,@PathVariable("id") Long iduser) {
        productService.ajouterEtaffecterListeProduct(lp, iduser);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProductu(
            @RequestParam String type,
            @RequestParam String picture,
            @RequestParam String description,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam Long userId) {

        Product product = productService.addProductU(type, picture, description, name, phone, email, address, userId);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {

        Product updatedProduct = productService.updateProduct(id,product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Endpoint pour supprimer un produit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
