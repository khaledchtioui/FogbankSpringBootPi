package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void deleteProduct(Integer id);
    Product addProduct(Product product);
    Product updateProduct(Integer id,Product product);
    List<Product> getProductsByUserId(Integer userId);
    Product findProduct(Integer id);
    Product addProductU(String type, String picture, String description, String name, String phone, String email, String address, Long userId);

    void ajouterEtaffecterListeProduct (List<Product> lb, Long iduser);
    Product getProductById(Integer id);

}
