package com.example.demo.Model.File;

import lombok.Data;

@Data
public class FileDeleteRequest {

  private String path;

  public FileDeleteRequest(String path) {
    this.path = path;
  }

  public FileDeleteRequest() {
  }
}
