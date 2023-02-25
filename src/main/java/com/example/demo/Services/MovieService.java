package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Movie;
import com.example.demo.Interfaces.MovieRepository;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> getMovieById(ObjectId id) {
    return movieRepository.findById(id);
  }
}
