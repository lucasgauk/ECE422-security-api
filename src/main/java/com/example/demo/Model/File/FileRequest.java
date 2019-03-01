package com.example.demo.Model.File;

import lombok.Data;

@Data
public class FileRequest {

  private byte[] bytes;
  private String extension;
  private String fileName;
  private String path;

  public FileRequest(byte[] bytes, String extension, String fileName, String path) {
    this.bytes = bytes;
    this.extension = extension;
    this.fileName = fileName;
    this.path = path;
  }

  public String getPath() {
    if (this.path == null) { return ""; }
    return this.path;
  }

  public FileRequest() {
  }
}
