package com.example.demo.Service.Implementation;

import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import com.example.demo.Repository.UserGroupRepository;
import com.example.demo.Service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImp implements UserGroupService {

  private UserGroupRepository userGroupRepository;

  @Autowired
  public UserGroupServiceImp(UserGroupRepository userGroupRepository) {
    this.userGroupRepository = userGroupRepository;
  }

  @Override public UserGroup getUserGroupByUser(User user) {
    return this.userGroupRepository.getByUsers(user);
  }
}
