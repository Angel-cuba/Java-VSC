package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.MovieService;

@RestController
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
    // return ResponseEntity.ok("Hello World from my Java app!");
    return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);

  }
}
