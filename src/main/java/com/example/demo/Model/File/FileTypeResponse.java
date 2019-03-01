package com.example.demo.Model.File;

import java.util.Date;
import lombok.Data;

@Data
public class FileTypeResponse {

  private String path;
  private String fileType;
  private Date createdAt;
  private Date modifiedAt;

  public FileTypeResponse(String path, String fileType, Date createdAt, Date modifiedAt) {
    this.path = path;
    this.fileType = fileType;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }
}
