package com.example.demo.Repository;

import com.example.demo.Model.User.User;
import com.example.demo.Model.UserGroup.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

  UserGroup getByUsers(User user);

  UserGroup getAllByName(String name);

  UserGroup findAllById(Long id);
}
