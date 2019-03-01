package com.example.demo.Model.Permission;

import com.example.demo.Model.File.File;
import com.example.demo.Model.User.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "permission")
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private boolean readAllowed;
  private boolean writeAllowed;

  @ManyToOne
  @JoinColumn(name = "file")
  private File file;
  @ManyToOne
  @JoinColumn(name = "user")
  private User user;

  public Permission(boolean read, boolean write, File file, User user) {
    this.readAllowed = read;
    this.writeAllowed = write;
    this.file = file;
    this.user = user;
  }

  public Permission() {
  }
}
