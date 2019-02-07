package com.example.demo.Service;

import com.example.demo.Model.File.FileTypeResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface FileService {

  List<FileTypeResponse> getFiles(String path);

  String getFileType(String path);

  byte[] getFileBytes(String path) throws IOException;

}
