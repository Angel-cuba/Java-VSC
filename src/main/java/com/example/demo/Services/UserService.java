package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.interfaces.UserRepository;
import com.example.demo.models.User;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;


  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public ResponseEntity<String> getUserById(String id) {
    Optional<User> user = userRepository.findById(id);

    if (!user.isPresent()) {
      return new ResponseEntity<String>("User with id " +id +" not found", HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<String>("User with id " +id +" found" + user.get(), HttpStatus.OK);
    }
  }

  public ResponseEntity<User> getUserByEmail(String email) {
    Optional<User> user = userRepository.findUserByEmail(email);

    if (!user.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    } else {
      return user.map(ResponseEntity::ok).get();
    }
  }

  public ResponseEntity<User> createUser(User user) {
      // user.setPassword(passwordEncoder.encode(user.getPassword()));
      userRepository.save(user);
      return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

  public ResponseEntity<User> updateUser(User user) {
    User userExist = userRepository.findById(user.get_id()).get();

    if (userExist != null) {
      userExist.setUserName(user.getUserName());
      userExist.setFirstName(user.getFirstName());
      userExist.setLastName(user.getLastName());
      userExist.setProfilePicture(user.getProfilePicture());
      userExist.setEmail(user.getEmail());
      userExist.setPassword(user.getPassword());
      userRepository.save(userExist);
      return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }
  }  

  public ResponseEntity<String> deleteUser(String id) {
    Optional<User> user = userRepository.findById(id);

    if (!user.isPresent()) {
      return new ResponseEntity<String>("User with id " +id +" not found", HttpStatus.NOT_FOUND);
    } else {
      userRepository.deleteById(id);
      return new ResponseEntity<String>("User with id " +id +" deleted", HttpStatus.OK);
    }
  }
}
