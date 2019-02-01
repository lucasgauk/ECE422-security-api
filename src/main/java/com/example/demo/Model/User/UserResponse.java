package com.example.demo.Model.User;

import lombok.Data;

@Data
public class UserResponse {
  private int id;
  private String username;
  private String password;

  public UserResponse(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public static UserResponse fromModel(User user) {
    return new UserResponse(user.getId(),
                            user.getUsername(),
                            user.getPassword());
  }
}
