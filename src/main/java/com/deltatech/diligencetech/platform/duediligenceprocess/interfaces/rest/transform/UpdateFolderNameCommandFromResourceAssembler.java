package com.deltatech.diligencetech.platform.duediligenceprocess.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprocess.domain.model.commands.UpdateFolderNameCommand;

public class UpdateFolderNameCommandFromResourceAssembler {
  public static UpdateFolderNameCommand toCommandFromResource(Long folderId, String name) {
    return new UpdateFolderNameCommand(folderId, name);
  }
}
