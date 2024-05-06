package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.LostProduct;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LostProductService {
    List<LostProduct> getAllLostProducts();
    void deleteLostProduct(Integer id);
    LostProduct addLostProduct(LostProduct lostProduct);
    LostProduct updateLostProduct(LostProduct lostProduct);
    void ajouterEtaffecterListeLostProduct (Integer idp, Long idu);
    List<Object[]> getAllLostProduct();

}
