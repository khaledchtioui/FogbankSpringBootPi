package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Adhésion;
import com.fogbank.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdhésionRepository extends JpaRepository<Adhésion,Integer> {
    List<Adhésion> findByUserId(Integer userId);
    List<Adhésion> findByClubIDClub(Integer clubId);
}
