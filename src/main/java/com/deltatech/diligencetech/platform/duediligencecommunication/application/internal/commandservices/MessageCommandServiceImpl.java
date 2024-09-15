package com.deltatech.diligencetech.platform.duediligencecommunication.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligencecommunication.domain.model.aggregates.Message;
import com.deltatech.diligencetech.platform.duediligencecommunication.domain.model.commands.CreateMessageCommand;
import com.deltatech.diligencetech.platform.duediligencecommunication.domain.services.MessageCommandService;
import com.deltatech.diligencetech.platform.duediligencecommunication.infrastructure.persistence.jpa.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MessageCommandServiceImpl implements MessageCommandService {
    private final MessageRepository emailRepository;

    public MessageCommandServiceImpl(MessageRepository emailRepository) {
        this.emailRepository = emailRepository;
    }
    @Override
    public Optional<Message> handle(CreateMessageCommand command) {
        var email = new Message(command);
        emailRepository.save(email);
        return Optional.of(email);
    }

}
