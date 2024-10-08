package com.deltatech.diligencetech.platform.duediligenceprocess.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
  List<Document> findByFolder(Folder folder);
  Optional<Document> findByfilename(String filename);
  boolean existsByFilename(String filename);
}