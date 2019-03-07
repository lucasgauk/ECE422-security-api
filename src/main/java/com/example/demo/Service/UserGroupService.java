package com.example.demo.Service;

import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import org.springframework.stereotype.Service;

@Service
public interface UserGroupService {

  UserGroup getUserGroupByUser(User user);

  void save(UserGroup userGroup);

  UserGroup getUserGroup(Long id);

  UserGroup getUserGroup(String name);

}
