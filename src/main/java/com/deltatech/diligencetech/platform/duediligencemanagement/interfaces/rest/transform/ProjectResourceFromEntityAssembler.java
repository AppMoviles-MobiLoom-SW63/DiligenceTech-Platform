package com.deltatech.diligencetech.platform.duediligencemanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligencemanagement.interfaces.rest.resources.ProjectResource;

public class ProjectResourceFromEntityAssembler {
    
    public static ProjectResource toResourceFromEntity(Project entity) {
        return new ProjectResource(entity.getId(), entity.getName(), entity.getActive());
    }
}