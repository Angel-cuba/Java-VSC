package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.MovieRepository;
import com.example.demo.models.Movie;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> getMovieById(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }
}
