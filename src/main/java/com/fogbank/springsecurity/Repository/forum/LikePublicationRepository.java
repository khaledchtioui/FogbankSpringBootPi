package com.fogbank.springsecurity.Repository.forum;

import com.fogbank.springsecurity.entities.forum.LikePublication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikePublicationRepository  extends JpaRepository<LikePublication, Integer> {
}
