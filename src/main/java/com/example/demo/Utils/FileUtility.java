package com.example.demo.Utils;

public class FileUtility {

  public static String getExtension(String path) {
    String extension = "";

    int i = path.lastIndexOf('.');
    if (i > 0) {
      extension = path.substring(i+1);
    }

    return extension;
  }

}
