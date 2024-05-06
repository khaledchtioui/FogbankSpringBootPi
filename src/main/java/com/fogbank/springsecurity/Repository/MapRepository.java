package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Integer> {
    Map findByProductId(Integer productId);

}
