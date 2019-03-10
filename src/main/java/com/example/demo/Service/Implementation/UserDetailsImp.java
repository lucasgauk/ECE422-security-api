package com.example.demo.Service.Implementation;

import com.example.demo.Model.User.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {

  private UserService userService;

  @Autowired
  public UserDetailsImp(UserService userService) {
    this.userService = userService;
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.toUserDetails(this.userService.getUser(username));
  }

  private UserDetails toUserDetails(User user) {
    return org.springframework.security.core.userdetails.User
        .withUsername(user.getUsername())
        .password("{noop}" + user.getPassword()) // TODO: Stored in plain text... bad!
        .roles("USER").build();
  }
}
