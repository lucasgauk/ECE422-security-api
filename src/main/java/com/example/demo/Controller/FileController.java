package com.example.demo.Controller;

import com.example.demo.Model.File.FileRequest;
import com.example.demo.Model.File.FileResponse;
import com.example.demo.Model.File.FileTypeResponse;
import com.example.demo.Service.FileService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

  private FileService fileService;

  @Autowired
  public FileController(FileService fileService) {
    this.fileService = fileService;
  }

  @GetMapping
  public ResponseEntity<List<FileTypeResponse>> getAllFiles(@RequestParam(required = false) String path) {
    List<FileTypeResponse> files = this.fileService.getFiles(path == null ? "" : path);
    if (files == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(files);
  }

  @GetMapping("/bytes")
  public ResponseEntity<FileResponse> getFileBytes(@RequestParam String path) {
    try {
      return ResponseEntity.ok(new FileResponse(fileService.getFileBytes(path), fileService.getFileType(path)));
    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping
  public ResponseEntity uploadFile(@RequestBody FileRequest fileRequest) {
    if (this.fileService.saveFile(fileRequest)) {
      return new ResponseEntity(HttpStatus.CREATED);
    } else {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
