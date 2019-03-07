package com.example.demo.Model.UserGroup;

import lombok.Data;

@Data
public class UserGroupResponse {

  private Long id;
  private String name;

  public UserGroupResponse(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static UserGroupResponse fromModel(UserGroup userGroup) {
    return new UserGroupResponse(userGroup.getId(),
                                 userGroup.getName());
  }

}
