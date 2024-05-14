package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.ClubEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubEventRepository extends JpaRepository<ClubEvent, Long> {
}
