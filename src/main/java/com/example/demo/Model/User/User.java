package com.example.demo.Model.User;

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
@Table(name = "user")
public class User {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private int id;

  private String username;
  private String password;

  @JsonIgnore
  @OneToMany(mappedBy = "user") private List<Permission> permissions;

  public User() {}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
