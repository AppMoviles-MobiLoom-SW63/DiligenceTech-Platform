package com.deltatech.diligencetech.platform.duediligenceprocess.infrastructure.persistence.jpa.repositories;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.aggregates.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
  List<Folder> findByParent(Area parent);
}
