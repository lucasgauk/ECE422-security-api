package com.example.demo.Model.File;

import java.io.File;
import lombok.Data;

@Data
public class FileResponse {

  private File file;
  private String type;

  public FileResponse(File file, String type) {
    this.file = file;
    this.type = type;
  }

  public static FileResponse fromFile(File file) {
    return null;
  }
}
