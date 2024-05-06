package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByUserpId(Integer userId);

}
