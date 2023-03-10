package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  private ObjectId id;
  private String username;
  private String firstName;
  private String lastName;
  private String profilePicture;
  private String email;
  private String password;
  private String role;

  public User(String username, String firstName, String lastName, String profilePicture, String email, String password, String role) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.profilePicture = profilePicture;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
