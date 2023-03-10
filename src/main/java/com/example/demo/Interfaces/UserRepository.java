package com.example.demo.interfaces;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
  Optional<User> findUserByEmail(String email);
}
