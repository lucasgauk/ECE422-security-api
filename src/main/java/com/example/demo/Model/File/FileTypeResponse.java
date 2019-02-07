package com.example.demo.Model.File;

import lombok.Data;

@Data
public class FileTypeResponse {

  private String path;
  private String fileType;

  public FileTypeResponse(String path, String fileType) {
    this.path = path;
    this.fileType = fileType;
  }
}
