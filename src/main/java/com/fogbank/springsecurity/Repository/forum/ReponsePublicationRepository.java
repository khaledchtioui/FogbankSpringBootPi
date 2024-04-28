package com.fogbank.springsecurity.Repository.forum;

import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponsePublicationRepository  extends JpaRepository<ReponsePublication, Integer> {
}
