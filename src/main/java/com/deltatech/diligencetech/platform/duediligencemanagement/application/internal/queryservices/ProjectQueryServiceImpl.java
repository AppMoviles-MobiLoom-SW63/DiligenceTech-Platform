package com.deltatech.diligencetech.platform.duediligencemanagement.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligencemanagement.application.internal.outboundservices.acl.DueDiligenceManagementExternalsService;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.entities.Member;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetAllProjectMembersByProjectId;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.queries.GetProjectsByUsernameQuery;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.services.ProjectQueryService;
import com.deltatech.diligencetech.platform.duediligencemanagement.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectQueryServiceImpl implements ProjectQueryService {
    private final ProjectRepository projectRepository;
    private final DueDiligenceManagementExternalsService dueDiligenceManagementExternalsService;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository, DueDiligenceManagementExternalsService dueDiligenceManagementExternalsService) {
        this.projectRepository = projectRepository;
        this.dueDiligenceManagementExternalsService = dueDiligenceManagementExternalsService;
    }

    @Override
    public Optional<Project> handle(GetProjectByIdQuery query) {
        return projectRepository.findById(query.projectId());
    }

    @Override
    public List<Project> handle(GetAllProjectsQuery query) {
        return projectRepository.findAll();
    }

    @Override
    public List<Member> handle(GetAllProjectMembersByProjectId query) {
        var project = projectRepository.findById(query.projectId());
        return project.map(Project::getMembers).orElse(Collections.emptyList());
    }

    @Override
    public List<Project> handle(GetProjectsByUsernameQuery query) {
        // done manually unfortunately
        // get userId from username
        var userId = dueDiligenceManagementExternalsService.fetchUserIdByUsername(query.username());
        if (userId.isEmpty()) {
            return Collections.emptyList();
        }
        return projectRepository.findAllByMembersSpecificUserId(userId.get());
    }
}