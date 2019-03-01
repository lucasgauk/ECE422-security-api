package com.example.demo.Model.UserGroup;

import com.example.demo.Model.User.User;
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
@Table(name = "user_group")
public class UserGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "userGroup")
  private List<User> users;

  public UserGroup() {
  }

  public UserGroup(String name) {
    this.name = name;
  }
}
