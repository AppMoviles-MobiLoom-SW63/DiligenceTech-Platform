package com.deltatech.diligencetech.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.profiles.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Boolean existsByUsername(String username);
}
