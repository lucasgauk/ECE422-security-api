package com.example.demo.Model.File;

import lombok.Data;

@Data
public class FileResponse {

  private byte[] bytes;
  private String extension;

  public FileResponse(byte[] bytes, String extension) {
    this.bytes = bytes;
    this.extension = extension;
  }

}
