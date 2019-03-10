package com.example.demo.Repository;

import com.example.demo.Model.File.File;
import com.example.demo.Model.Permission.Permission;
import com.example.demo.Model.User.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

  List<Permission> getAllByFileAndUserAndReadAllowedIsTrue(File file, User user);

  List<Permission> getAllByFileAndUserAndWriteAllowedIsTrue(File file, User user);

  List<Permission> getAllByUser(User user);

  void deleteAllByFile(File file);
}
