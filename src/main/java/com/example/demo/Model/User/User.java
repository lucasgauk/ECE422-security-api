package com.example.demo.Model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private int id;

  private String username;
  private String password;

  public User() {}

  public User(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }
}
