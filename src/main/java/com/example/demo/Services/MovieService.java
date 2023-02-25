package com.example.demo.Services;

import java.util.List;

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
}
