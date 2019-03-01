package com.example.demo.Service.Implementation;

import com.example.demo.Model.File.FileRequest;
import com.example.demo.Model.File.FileTypeResponse;
import com.example.demo.Model.Permission.Permission;
import com.example.demo.Model.User.User;
import com.example.demo.Repository.FileSystemRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.FileService;
import com.example.demo.Service.FileSystemService;
import com.example.demo.Service.PermissionService;
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
  private FileService fileService;
  private PermissionService permissionService;
  private UserRepository userRepository;

  @Value("${filesystem.basepath}")
  private String basePath;

  @Autowired
  public FileSystemServiceImp(FileSystemRepository fileSystemRepository, FileService fileService,
                              PermissionService permissionService, UserRepository userRepository) {
    this.fileSystemRepository = fileSystemRepository;
    this.fileService = fileService;
    this.permissionService = permissionService;
    this.userRepository = userRepository;
  }

  @Override
  public List<FileTypeResponse> getFiles(String path, String username) {
    File[] files = this.fileSystemRepository.getAll(basePath + path);
    if (files == null) { return null; }
    return new ArrayList<>(Arrays.asList(files)).stream()
                                                .map(file -> new FileTypeResponse(file.getPath().replace(basePath, "/"),
                                                                                  this.getFileType(file.getPath().replace(basePath, "/"))))
                                                .filter(file -> this.permissionService.authorizedToRead(
                                                    this.userRepository.getUserByUsername(username),
                                                    this.fileService.findByPath(file.getPath().replace(basePath, "/"))))
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
   * Save new file into the filesystem and the database. Add a new permission for it.
   */
  public boolean saveFile(FileRequest file, String createdBy) {
    if (this.fileSystemRepository.saveFile(file.getBytes(), this.basePath + file.getPath() + "/" + file.getFileName())) {
      com.example.demo.Model.File.File fileModel = com.example.demo.Model.File.File.fromRequest(file);
      this.fileService.save(fileModel);
      this.permissionService.save(new Permission(true, true, fileModel, this.userRepository.getUserByUsername(createdBy)));
      return true;
    }
    return false;
  }
}
