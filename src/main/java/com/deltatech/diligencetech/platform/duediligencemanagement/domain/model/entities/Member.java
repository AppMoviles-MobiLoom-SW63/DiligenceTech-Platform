package com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.entities;

import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligencemanagement.domain.model.valueobjects.DueDiligenceRole;
import com.deltatech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class Member extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project;

    @Column
    private Long userId;

    @Column
    private DueDiligenceRole agentRole;

    @Column
    private Boolean hasAcceptedInvitation;

    public Member() {
    }

    public Member(Long userId, Project project) {
        this.userId = userId;
        this.hasAcceptedInvitation = false;
        this.project = project;
    }

}