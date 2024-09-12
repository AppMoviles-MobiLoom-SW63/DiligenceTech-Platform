package com.deltatech.diligencetech.platform.duediligencecommunication.domain.model.aggregates;


import com.deltatech.diligencetech.platform.duediligencecommunication.domain.model.commands.CreateMessageCommand;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;



@Getter
@Entity
public class Message extends AuditableAbstractAggregateRoot<Message> {
    @Column
    private Long projectId;

    @Column
    private Long userId;

    @Column
    private String message;

    public Message() {
    }

    public Message(CreateMessageCommand command){
        this.projectId = command.projectId();
        this.userId = command.userId();
        this.message = command.message();
    }

}
