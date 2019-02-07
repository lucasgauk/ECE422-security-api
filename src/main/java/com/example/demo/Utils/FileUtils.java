package com.example.demo.Utils;

public class FileUtils {

  public static String getExtension(String path) {
    String extension = "";

    int i = path.lastIndexOf('.');
    if (i > 0) {
      extension = path.substring(i+1);
    }

    return extension;
  }

}
