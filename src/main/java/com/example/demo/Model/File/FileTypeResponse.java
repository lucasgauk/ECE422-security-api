package com.example.demo.Model.File;

import java.util.Date;
import lombok.Data;

@Data
public class FileTypeResponse {

  private Long id;
  private String path;
  private String fileType;
  private Date createdAt;
  private Date modifiedAt;

  public FileTypeResponse(Long id, String path, String fileType, Date createdAt, Date modifiedAt) {
    this.id = id;
    this.path = path;
    this.fileType = fileType;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }
}
