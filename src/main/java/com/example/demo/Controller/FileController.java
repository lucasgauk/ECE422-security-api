package com.example.demo.Controller;

import com.example.demo.Model.File.FileDeleteRequest;
import com.example.demo.Model.File.FileRequest;
import com.example.demo.Model.File.FileResponse;
import com.example.demo.Model.File.FileTypeResponse;
import com.example.demo.Service.FileSystemService;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

  private FileSystemService fileSystemService;

  @Autowired
  public FileController(FileSystemService fileSystemService) {
    this.fileSystemService = fileSystemService;
  }

  @GetMapping
  public ResponseEntity<List<FileTypeResponse>> getAllFiles(@RequestParam(required = false) String path, Principal principal) {
    List<FileTypeResponse> files = this.fileSystemService.getFiles(path == null ? "" : path, principal.getName());
    if (files == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(files);
  }

  @GetMapping("/bytes")
  public ResponseEntity<FileResponse> getFileBytes(@RequestParam String path) {
    try {
      return ResponseEntity.ok(new FileResponse(this.fileSystemService.getFileBytes(path),
                                                this.fileSystemService.getFileType(path),
                                                this.fileSystemService.getCreatedAt(path),
                                                this.fileSystemService.getModifiedAt(path)));
    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping
  public ResponseEntity uploadFile(@RequestBody FileRequest fileRequest, Principal principal) {
    if (this.fileSystemService.saveFile(fileRequest, principal.getName())) {
      return new ResponseEntity(HttpStatus.CREATED);
    } else {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/delete")
  public ResponseEntity deleteFile(@RequestBody FileDeleteRequest request) {
    this.fileSystemService.deleteFile(request.getPath());
    return new ResponseEntity(HttpStatus.OK);
  }
}
