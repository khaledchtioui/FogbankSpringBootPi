package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.LostProductRepository;
import com.fogbank.springsecurity.Repository.ProductRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.LostProduct;
import com.fogbank.springsecurity.entities.Product;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.LostProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class LostProductServiceImp implements LostProductService {
    private LostProductRepository lostProductRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    public LostProductServiceImp(LostProductRepository lostProductRepository,UserRepository userRepository,ProductRepository productRepository) {
        this.lostProductRepository = lostProductRepository;
        this.userRepository=userRepository;
        this.productRepository=productRepository;
    }
    @Override
    public List<LostProduct> getAllLostProducts() {


        return lostProductRepository.findAll();
    }
@Override
    public List<Object[]> getAllLostProduct() {
        return lostProductRepository.findAllLostProduct();
    }
    @Override
    public void deleteLostProduct(Integer id) {
        lostProductRepository.deleteById(id);

    }

    @Override
    public LostProduct addLostProduct(LostProduct lostProduct) {
        return lostProductRepository.save(lostProduct);
    }

    @Override
    public LostProduct updateLostProduct(LostProduct lostProduct) {
        if (lostProductRepository.existsById(lostProduct.getId())) {
            return lostProductRepository.save(lostProduct);
        } else {
            throw new EntityNotFoundException("LostProduct not found with id: " + lostProduct.getId());
        }
    }

    @Override
    public void ajouterEtaffecterListeLostProduct(Integer idp, Long idu) {

        User user = userRepository.findById(idu)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + idu));
        Product product = productRepository.findById(idp)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + idp));
        LostProduct l=new LostProduct();
            l.setUserlp(user);
            l.setProductDetail(product);


        lostProductRepository.save(l);
    }


}
