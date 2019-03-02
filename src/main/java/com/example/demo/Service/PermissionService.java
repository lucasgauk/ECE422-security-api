package com.example.demo.Service;

import com.example.demo.Model.File.File;
import com.example.demo.Model.Permission.Permission;
import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PermissionService {

  List<Permission> getPermissionInterfaceByUser(User user);

  boolean authorizedToRead(User user, File file);

  boolean authorizedToWrite(User user, File file);

  void save(Permission permission);

  void authorizeGroup(UserGroup userGroup, File file);

  void deleteByFile(File file);

}
