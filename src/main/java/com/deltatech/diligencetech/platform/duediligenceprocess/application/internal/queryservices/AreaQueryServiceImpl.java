package com.deltatech.diligencetech.platform.duediligenceprocess.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.queries.GetAllAreasQuery;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.queries.GetAreaByIdQuery;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.queries.GetAreasByProjectIdQuery;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.services.AreaQueryService;
import com.deltatech.diligencetech.platform.duediligenceprocess.infrastructure.persistence.jpa.repositories.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaQueryServiceImpl implements AreaQueryService {

    private final AreaRepository areaRepository;

  public AreaQueryServiceImpl(AreaRepository areaRepository) {
    this.areaRepository = areaRepository;
  }


  @Override
    public List<Area> handle(GetAreasByProjectIdQuery query) {
        return areaRepository.findByProjectId(query.projectId());
    }

    @Override
    public Optional<Area> handle(GetAreaByIdQuery query) {
        return areaRepository.findById(query.areaId());
    }

    @Override
    public List<Area> handle(GetAllAreasQuery query) {
        return areaRepository.findAll();
    }




}
