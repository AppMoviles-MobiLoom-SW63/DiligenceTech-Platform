package com.deltatech.diligencetech.platform.duediligencemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.entities.Member;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetAllProjectMembersByProjectId;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetProjectByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryService {
    Optional<Project> handle(GetProjectByIdQuery query);
    List<Project> handle(GetAllProjectsQuery query);
    List<Member> handle(GetAllProjectMembersByProjectId query);
}
