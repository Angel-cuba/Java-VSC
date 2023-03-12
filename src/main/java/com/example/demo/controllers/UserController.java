package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable String id) {
    return userService.getUserById(id);
  }

  @GetMapping("/email")
  public ResponseEntity<User> getUserByEmail(@PathParam("email") String email) {
    return userService.getUserByEmail(email); 
  }

  @PostMapping("/create")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping("/update")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    return userService.updateUser(user);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable String id) {
    return userService.deleteUser(id);
  }  
}
