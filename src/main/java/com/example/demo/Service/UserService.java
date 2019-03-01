package com.example.demo.Service;

import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  User getUser(String username, String password);

  void save(User user);

  User getUser(String username);

  List<User> getUsersByUserGroup(UserGroup userGroup);

}
