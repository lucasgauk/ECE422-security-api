package com.example.demo.Service;

import com.example.demo.Model.User.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  User getUser(String username, String password);

  void save(User user);

  User getUser(String username);

}
