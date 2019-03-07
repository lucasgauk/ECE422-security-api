package com.example.demo.Controller;

import com.example.demo.Model.UserGroup.UserGroup;
import com.example.demo.Model.UserGroup.UserGroupResponse;
import com.example.demo.Service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

  private UserGroupService userGroupService;

  @Autowired
  public GroupController(UserGroupService userGroupService) {
    this.userGroupService = userGroupService;
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<UserGroupResponse> createGroup(@RequestBody UserGroup userGroup) {
    if (this.userGroupService.getUserGroup(userGroup.getName()) != null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    this.userGroupService.save(userGroup);
    return ResponseEntity.ok(UserGroupResponse.fromModel(this.userGroupService.getUserGroup(userGroup.getName())));
  }

}
