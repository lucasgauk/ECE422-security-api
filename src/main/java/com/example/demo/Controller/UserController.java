package com.example.demo.Controller;

import com.example.demo.Model.User.User;
import com.example.demo.Model.User.UserResponse;
import com.example.demo.Model.UserGroup.UserGroup;
import com.example.demo.Service.UserGroupService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserService userService;
  private UserGroupService userGroupService;

  @Autowired
  public UserController(UserService userService, UserGroupService userGroupService) {
    this.userService = userService;
    this.userGroupService = userGroupService;
  }

  @GetMapping("/login")
  @ResponseBody
  public UserResponse findUser(@RequestParam String username,
                               @RequestParam String password) {
    return UserResponse.fromModel(this.userService.getUser(username, password));
  }

  @PostMapping("/{groupId}")
  @ResponseBody
  public ResponseEntity<UserResponse> createUser(@PathVariable(value = "groupId") Long groupId, @RequestBody User user) {
    UserGroup userGroup = this.userGroupService.getUserGroup(groupId);
    if (this.userService.getUser(user.getUsername()) == null && userGroup != null) {
      user.setUserGroup(userGroup);
      this.userService.save(user);
      return ResponseEntity.ok(UserResponse.fromModel(this.userService.getUser(user.getUsername())));
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}