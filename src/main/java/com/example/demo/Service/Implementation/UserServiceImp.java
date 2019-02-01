package com.example.demo.Service.Implementation;

import com.example.demo.Model.User.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override public User getUser(String username, String password) {
    return this.userRepository.getUserByUsernameAndPassword(username, password);
  }
}
