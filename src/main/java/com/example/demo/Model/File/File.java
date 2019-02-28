package com.example.demo.Model.File;

import com.example.demo.Model.Permission.Permission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "file")
public class File {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String path;
  private String extension;
  private String fileName;

  @JsonIgnore
  @OneToMany(mappedBy = "file") private List<Permission> permissions;

  public File(String path, String extension, String fileName) {
    this.path = path;
    this.extension = extension;
    this.fileName = fileName;
  }

  public static File fromRequest(FileRequest request) {
    return new File(request.getPath(),
                    request.getExtension(),
                    request.getFileName());
  }
}
