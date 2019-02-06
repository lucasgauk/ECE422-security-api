package com.example.demo.Service.Implementation;

import com.example.demo.Repository.FileRepository;
import com.example.demo.Service.FileService;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImp implements FileService {

  private FileRepository fileRepository;
  @Value("${filesystem.basepath}")
  private String basepath;

  @Autowired
  public FileServiceImp(FileRepository fileRepository) {
    this.fileRepository = fileRepository;
  }

  @Override
  public List<String> getFileNames(String path) {
    File[] files = this.fileRepository.getAll(basepath + path);
    if (files == null) { return null; }
    return new ArrayList<>(Arrays.asList(files)).stream()
                                                .map(file -> file.getPath().replace(basepath, "/"))
                                                .collect(Collectors.toList());
  }
}
