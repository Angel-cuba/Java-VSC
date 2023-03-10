package com.example.demo.interfaces;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
  
}
