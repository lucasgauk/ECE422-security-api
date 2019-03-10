package com.example.demo.Model.File;

import lombok.Data;

@Data
public class FileDeleteRequest {

  private Long fileId;

  public FileDeleteRequest(Long fileId) {
    this.fileId = fileId;
  }

  public FileDeleteRequest() {
  }
}
