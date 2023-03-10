package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.UserRepository;
import com.example.demo.models.User;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;


  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public ResponseEntity<User> getUserById(ObjectId id) {
    Optional<User> user = userRepository.findById(id);

    if (user.isPresent()) {
      return user.map(ResponseEntity::ok).get();
    } else {
      return null;
    }
  }

  public ResponseEntity<User> getUserByEmail(String email) {
    Optional<User> user = userRepository.findUserByEmail(email);

    if (user.isPresent()) {
      return user.map(ResponseEntity::ok).get();
    } else {
      return null;
    }
  }

  public ResponseEntity<User> createUser(User user) {
    User newUser = userRepository.save(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  
}
