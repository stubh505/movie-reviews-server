package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Movie;
import com.kaustubh.moviereviews.portal.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesAPI {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getMovies () {
        List<Movie> movies = moviesService.getAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById (@PathVariable String movieId) {
        Movie movie = moviesService.getMovie(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie (@RequestBody Movie movie) {
        String res = moviesService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie (@PathVariable String movieId, @RequestBody Movie movie) {
        Movie res = moviesService.editMovie(movieId, movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
