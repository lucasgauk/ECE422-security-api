package com.example.demo.Service.Implementation;

import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void save(User user) {
    this.userRepository.save(user);
  }

  public User getUser(String username, String password) {
    return this.userRepository.getUserByUsernameAndPassword(username, password);
  }

  public User getUser(String username) { return this.userRepository.getUserByUsername(username); }

  @Override public List<User> getUsersByUserGroup(UserGroup userGroup) {
    return this.userRepository.getAllByUserGroup(userGroup);
  }

  @Override public List<User> getAll() {
    return this.userRepository.findAll();
  }
}
