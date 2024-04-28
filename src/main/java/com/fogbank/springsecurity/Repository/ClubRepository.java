package com.fogbank.springsecurity.Repository;


import com.fogbank.springsecurity.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository <Club,Integer> {

}
