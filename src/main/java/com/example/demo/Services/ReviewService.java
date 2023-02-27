package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import com.example.demo.interfaces.ReviewRepository;
import com.example.demo.models.Movie;
import com.example.demo.models.Review;

@Service
public class ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  public Review createReview(String reviewBody, String imdbId) {
    if(reviewBody == null || reviewBody.isEmpty()) {
      throw new IllegalArgumentException("Review body cannot be empty");
    }
     Review review = reviewRepository.insert(new Review(reviewBody));

      mongoTemplate.update(Movie.class)
        .matching(Criteria.where("imdbId").is(imdbId))
        .apply(new Update().push("reviewIds").value(review))
        .first();
        
      return review;
  }
}
