package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Review {
  @Id
    private ObjectId id;
    private String body;

    public ObjectId getId() {
      return id;
    }
    public void setId(ObjectId id) {
      this.id = id;
    }
    public String getBody() {
      return body;
    }
    public Review(String body) {
      this.body = body;
    }

}
