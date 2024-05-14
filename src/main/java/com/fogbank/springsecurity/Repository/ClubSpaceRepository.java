package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.ClubSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubSpaceRepository extends JpaRepository<ClubSpace, Long> {
}
