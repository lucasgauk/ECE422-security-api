package com.example.demo.Controller;

import com.example.demo.Model.User.UserResponse;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  @ResponseBody
  public UserResponse findUser(@RequestParam String username,
                               @RequestParam String password) {
    return UserResponse.fromModel(this.userService.getUser(username, password));
  }
}