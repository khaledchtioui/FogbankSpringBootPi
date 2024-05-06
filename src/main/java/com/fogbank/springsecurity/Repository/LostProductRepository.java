package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.LostProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LostProductRepository extends JpaRepository<LostProduct, Integer> {
    @Query("SELECT lp.id, lp.productDetail.id, lp.userlp.id FROM LostProduct lp")
    List<Object[]> findAllLostProduct();

}
