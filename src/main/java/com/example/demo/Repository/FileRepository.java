package com.example.demo.Repository;

import com.example.demo.Utils.FileUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository {

  public File[] getAll(String path) {
    return new File(path).listFiles();
  }

  public File getFile(String path) {
    return new File(path);
  }

  public byte[] getBytes(File file) throws IOException {
    return Files.readAllBytes(file.toPath());
  }

  public String getFileType(String path) {
    return new File(path).listFiles() == null ? FileUtility.getExtension(path) : "folder";
  }

  public boolean saveFile(byte[] bytes, String path) {
    try {
      FileOutputStream stream = new FileOutputStream(path);
      stream.write(bytes);
      stream.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
