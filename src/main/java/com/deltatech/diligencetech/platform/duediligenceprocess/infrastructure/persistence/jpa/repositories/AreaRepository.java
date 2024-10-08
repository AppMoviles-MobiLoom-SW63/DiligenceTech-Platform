package com.deltatech.diligencetech.platform.duediligenceprocess.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.aggregates.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
  List<Area> findByProjectId(Long projectId);
  Optional<Area> findByName(String name);
  boolean existsByName(String name);
}
