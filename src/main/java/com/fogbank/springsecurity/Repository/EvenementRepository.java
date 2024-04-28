package com.fogbank.springsecurity.Repository;
import com.fogbank.springsecurity.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}

