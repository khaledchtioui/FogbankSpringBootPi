package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ProductRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.Product;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ProductServiceImp implements ProductService {
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public ProductServiceImp(ProductRepository productRepository,UserRepository userRepository) {

        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product addProduct(Product product) {
return  productRepository.save(product);
    }

    public List<Product> getProductsByUserId(Integer userId) {
        // Utilisez la méthode du repository pour récupérer les produits par userp-id
        return productRepository.findByUserpId(userId);
    }
    public Product findProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouterEtaffecterListeProduct(List<Product> lb, Long iduser) {
        productRepository.saveAll(lb);
        User user = userRepository.findById(iduser).orElse(null);
        for (Product product : lb) {
            product.setUserp(user);
        }
        productRepository.saveAll(lb);
    }


    public Product addProductU(String type, String picture, String description, String name, String phone, String email, String address, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = new Product();
        product.setType(type);
        product.setPicture(picture);
        product.setDescription(description);
        product.setName(name);
        product.setPhone(phone);
        product.setEmail(email);
        product.setAddress(address);
        product.setUserp(user);

        return productRepository.save(product);
    }
    @Override
    public Product updateProduct(Integer id,Product product) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setType(product.getType());
            existingProduct.setPicture(product.getPicture());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setName(product.getName());
            existingProduct.setPhone(product.getPhone());
            existingProduct.setEmail(product.getEmail());
            existingProduct.setAddress(product.getAddress());
            // Enregistrer les modifications dans la base de données et le renvoyer
            return productRepository.save(existingProduct);
        } else {
            // Si le produit n'existe pas, lancez une exception ou gérez l'erreur d'une autre manière
            throw new EntityNotFoundException("Product not found with id: " + product.getId());
        }
    }
}
