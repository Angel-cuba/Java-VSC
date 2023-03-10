package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
  /**
   * Get all movies
   * Both methods work fine and return the same result
   */
  @GetMapping
  public ResponseEntity<List<Movie>> getMovies() {
    return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
  }

  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId) {
    return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId), HttpStatus.OK);
  }
}
