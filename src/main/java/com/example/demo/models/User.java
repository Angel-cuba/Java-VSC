package com.example.demo.models;

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
  private String _id;
  private String username;
  private String firstName;
  private String lastName;
  private String profilePicture;
  private String email;
  private String password;
  private String role;

}
