package com.fogbank.springsecurity.Repository.forum;

import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationInitialeRepository  extends JpaRepository<PublicationInitiale, Integer> {
    List<PublicationInitiale> findByVisibilityTrue();

}
