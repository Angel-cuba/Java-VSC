package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "reviews")
public class Review {
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
    public void setBody(String body) {
      this.body = body;
    }

}
