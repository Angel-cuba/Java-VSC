package com.example.demo.services;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.interfaces.ReviewRepository;
import com.example.demo.models.Review;

@Service
public class ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  private MongoTemplate mongoTemplate;

  public Review createReview(String reviewBody, ObjectId id) {
     Review review = new Review(reviewBody);
      reviewRepository.insert(review);

      return review;
  }
}
