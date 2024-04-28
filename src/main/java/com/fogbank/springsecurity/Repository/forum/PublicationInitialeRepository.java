package com.fogbank.springsecurity.Repository.forum;

import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationInitialeRepository  extends JpaRepository<PublicationInitiale, Integer> {
}
