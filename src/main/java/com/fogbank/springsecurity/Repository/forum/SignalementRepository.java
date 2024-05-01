package com.fogbank.springsecurity.Repository.forum;

import com.fogbank.springsecurity.entities.forum.SignalementPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalementRepository extends JpaRepository<SignalementPost,Long> {
}
