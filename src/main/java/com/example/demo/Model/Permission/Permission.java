package com.example.demo.Model.Permission;

import com.example.demo.Model.File.File;
import com.example.demo.Model.User.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  private boolean read;
  private boolean write;
  @ManyToOne private File file;
  @ManyToOne private User user;
}
