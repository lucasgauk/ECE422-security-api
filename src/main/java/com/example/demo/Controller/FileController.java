package com.example.demo.Controller;

import com.example.demo.Service.FileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("files")
  @ResponseBody
  public List<String> getAllFiles(@RequestParam(required = false) String path) {
    return this.fileService.getFileNames(path == null ? "" : path);
  }
}
