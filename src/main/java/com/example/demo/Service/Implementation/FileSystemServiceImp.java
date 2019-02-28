package com.example.demo.Service.Implementation;

import com.example.demo.Model.File.FileRequest;
import com.example.demo.Model.File.FileTypeResponse;
import com.example.demo.Repository.FileRepository;
import com.example.demo.Repository.FileSystemRepository;
import com.example.demo.Service.FileSystemService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileSystemServiceImp implements FileSystemService {

  private FileSystemRepository fileSystemRepository;
  private FileRepository fileRepository;

  @Value("${filesystem.basepath}")
  private String basePath;

  @Autowired
  public FileSystemServiceImp(FileSystemRepository fileSystemRepository, FileRepository fileRepository) {
    this.fileSystemRepository = fileSystemRepository;
    this.fileRepository = fileRepository;
  }

  @Override
  public List<FileTypeResponse> getFiles(String path) {
    File[] files = this.fileSystemRepository.getAll(basePath + path);
    if (files == null) { return null; }
    return new ArrayList<>(Arrays.asList(files)).stream()
                                                .map(file -> new FileTypeResponse(file.getPath().replace(basePath, "/"),
                                                                                  this.getFileType(file.getPath().replace(basePath, "/"))))
                                                .collect(Collectors.toList());
  }

  @Override
  public String getFileType(String path) {
    return this.fileSystemRepository.getFileType(basePath + path);
  }

  @Override
  public byte[] getFileBytes(String path) throws IOException {
    return this.fileSystemRepository.getBytes(new File(basePath + path));
  }

  /**
   * Save new file into the filesystem and the database.
   */
  public boolean saveFile(FileRequest file) {
    if (this.fileSystemRepository.saveFile(file.getBytes(), this.basePath + file.getPath() + file.getFileName() + "." + file.getExtension())) {
      this.fileRepository.save(com.example.demo.Model.File.File.fromRequest(file));
      return true;
    }
    return false;
  }
}
