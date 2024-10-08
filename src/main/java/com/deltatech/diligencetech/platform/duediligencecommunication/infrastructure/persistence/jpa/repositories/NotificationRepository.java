package com.deltatech.diligencetech.platform.duediligencecommunication.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligencecommunication.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
    List<Notification> findByAgentId(Long agentId);
}