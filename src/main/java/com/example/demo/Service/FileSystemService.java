package com.example.demo.Service;

import com.example.demo.Model.File.FileRequest;
import com.example.demo.Model.File.FileTypeResponse;
import com.example.demo.Model.User.User;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface FileSystemService {

  List<FileTypeResponse> getFiles(String path, String username);

  String getFileType(String path);

  byte[] getFileBytes(String path) throws IOException;

  boolean saveFile(FileRequest file, String username);

}
