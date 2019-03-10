package com.example.demo.Model.File;

import java.util.Date;
import lombok.Data;

@Data
public class FileResponse {

  private byte[] bytes;
  private String extension;
  private Date createdAt;
  private Date modifiedAt;

  public FileResponse(byte[] bytes, String extension, Date createdAt, Date modifiedAt) {
    this.bytes = bytes;
    this.extension = extension;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }
}
