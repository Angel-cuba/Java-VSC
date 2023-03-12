package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.User;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findUserByEmail(String email);
  Optional<User> findUserByUserName(String userName);
}
