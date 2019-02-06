package com.example.demo.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository {

  public File[] getAll(String path) {
    return new File(path).listFiles();
  }

  public File getFile(String path){
    return new File(path);
  }

  public byte[] getBytes(File file) throws IOException {
    return Files.readAllBytes(file.toPath());
  }

}
