package com.example.demo.Service.Implementation;

import com.example.demo.Model.File.File;
import com.example.demo.Repository.FileRepository;
import com.example.demo.Service.FileService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImp implements FileService {

  private FileRepository fileRepository;

  @Autowired
  public FileServiceImp(FileRepository fileRepository) {
    this.fileRepository = fileRepository;
  }

  public void save(File file) {
    this.fileRepository.save(file);
  }

  public File findByPath(String path) {
    return this.fileRepository.findByPath(path);
  }

  @Override
  @Transactional
  public void deleteByPath(String path) {
    this.fileRepository.deleteAllByPath(path);
  }
}
