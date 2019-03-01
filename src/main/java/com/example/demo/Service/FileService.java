package com.example.demo.Service;

import com.example.demo.Model.File.File;
import org.springframework.stereotype.Service;

@Service
public interface FileService {

  void save(File file);

  File findByPath(String path);

}
