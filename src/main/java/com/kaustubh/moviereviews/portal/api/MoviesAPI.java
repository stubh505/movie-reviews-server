package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import com.kaustubh.moviereviews.portal.models.Review;
import com.kaustubh.moviereviews.portal.services.MoviesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@ApiOperation("Endpoints related to operations regarding movies")
public class MoviesAPI {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/all")
    @ApiOperation("GET all movies")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<List<Movie>> getMovies () {
        List<Movie> movies = moviesService.getAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    @ApiOperation("GET movie by ID")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<Movie> getMovieById (@PathVariable String movieId) {
        Movie movie = moviesService.getMovie(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation("POST method to add new movie")
    @ApiResponse(code = 201, message = "Created")
    public ResponseEntity<String> addMovie (@RequestBody Movie movie) {
        String res = moviesService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    @ApiOperation("PUT method to update existing movie")
    @ApiResponse(code = 201, message = "Created")
    public ResponseEntity<Movie> updateMovie (@PathVariable String movieId, @RequestBody Movie movie) {
        Movie res = moviesService.editMovie(movieId, movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}/actors")
    @ApiOperation("GET all actors of a movie")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<List<Actor>> getMovieActors(@PathVariable String movieId) {
        return null;
    }

    @GetMapping("/{movieId}/reviews")
    @ApiOperation("GET all reviews of a movie")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable String movieId) {
        return null;
    }

    @PostMapping("/{movieId}/reviews/")
    @ApiOperation("GET all reviews of a movie")
    @ApiResponse(code = 200, message = "Okay")
    public ResponseEntity<String> addReview(@PathVariable String movieId, @RequestBody Review review) {
        return null;
    }
}
