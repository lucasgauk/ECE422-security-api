package com.example.demo.Repository;

import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User getUserByUsernameAndPassword(String username, String password);

  User getUserByUsername(String username);

  List<User> getAllByUserGroup(UserGroup userGroup);

}
