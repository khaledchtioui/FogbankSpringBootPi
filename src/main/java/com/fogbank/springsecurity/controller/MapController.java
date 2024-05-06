package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.Map;
import com.fogbank.springsecurity.entities.Product;
import com.fogbank.springsecurity.services.ProductService;
import com.fogbank.springsecurity.services.impl.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/map")
@CrossOrigin(origins = "http://localhost:4200")
public class MapController {
    @Autowired
    private ProductService productService;

    @Autowired
    private MapService mapService;

    @PostMapping("/products/{productId}/maps")
    public ResponseEntity<Map> addMapToProduct(@PathVariable Integer productId, @RequestBody Map map) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        map.setProduct(product);
        Map savedMap = mapService.saveMap(map);
        return new ResponseEntity<>(savedMap, HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<Map> getProductCoordinates(@PathVariable Integer productId) {
        Map map = mapService.getCoordinatesByProductId(productId);
        if (map != null) {
            return ResponseEntity.ok(map);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
