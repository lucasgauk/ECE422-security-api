package com.example.demo.Service.Implementation;

import com.example.demo.Model.File.File;
import com.example.demo.Model.Permission.Permission;
import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import com.example.demo.Repository.PermissionRepository;
import com.example.demo.Service.PermissionService;
import com.example.demo.Service.UserService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImp implements PermissionService {

  private PermissionRepository permissionRepository;
  private UserService userService;

  @Autowired
  public PermissionServiceImp(PermissionRepository permissionRepository, UserService userService) {
    this.permissionRepository = permissionRepository;
    this.userService = userService;
  }

  public List<Permission> getPermissionInterfaceByUser(User user) {
    return this.permissionRepository.getAllByUser(user);
  }

  public boolean authorizedToRead(User user, File file) {
    return (this.permissionRepository.getAllByFileAndUserAndReadAllowedIsTrue(file, user).size() > 0);
  }

  public boolean authorizedToWrite(User user, File file) {
    return (this.permissionRepository.getAllByFileAndUserAndWriteAllowedIsTrue(file, user).size() > 0);
  }

  @Transactional
  public void save(Permission permission) {
    this.permissionRepository.save(permission);
  }

  @Transactional
  @Override public void authorizeGroup(UserGroup userGroup, File file) {
    List<User> usersInGroup = this.userService.getUsersByUserGroup(userGroup);
    usersInGroup.forEach(user -> this.save(new Permission(true, true, file, user)));
  }

  @Override
  @Transactional
  public void deleteByFile(File file) {
    this.permissionRepository.deleteAllByFile(file);
  }
}
