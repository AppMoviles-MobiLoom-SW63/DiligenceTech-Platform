package com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.valueobjects.*;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
public class Area extends AuditableAbstractAggregateRoot<Area> {


    @Embedded
    private FoldersList folders;

    @Column
    @Getter
    private Long projectId;

    @Column
    @Getter
    private String name;

    public Area(CreateAreaCommand command) {

        this.projectId = command.projectId();
        this.name = command.name();
        this.folders = new FoldersList();

    }

    public Area() {

    }

    public Area updateName(String name) {

        this.name = name;
        return this;

    }
}
