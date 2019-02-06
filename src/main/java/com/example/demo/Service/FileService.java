package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface FileService {

  List<String> getFileNames(String path);

}
