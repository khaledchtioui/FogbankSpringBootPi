package com.fogbank.springsecurity.Repository.forum;

import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReponsePublicationRepository  extends JpaRepository<ReponsePublication, Integer> {
    List<ReponsePublication> findByVisibilityTrue();

}
