package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.interfaces.UserRepository;
import com.example.demo.models.User;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional <User> userInfo =  userRepository.findUserByUserName(username);
        userInfo.map(UserInfoAndDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
        return null;
  }

}
