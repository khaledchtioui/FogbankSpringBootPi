package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.ClubEventCom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubEventComRepository extends JpaRepository<ClubEventCom, Long> {
}
