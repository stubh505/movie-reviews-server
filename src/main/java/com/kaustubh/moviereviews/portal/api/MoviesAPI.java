package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import com.kaustubh.moviereviews.portal.models.Review;
import com.kaustubh.moviereviews.portal.services.MoviesService;
import com.kaustubh.moviereviews.portal.services.ReviewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/all")
    @ApiOperation(value = "GET all movies", notes = "Returns list of movies")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Movies retrieved successfully"),
                    @ApiResponse(code = 404, message = "No movies retrieved")
            }
    )
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = moviesService.getAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    @ApiOperation(value = "GET movie by ID", notes = "Returns movie")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Movie retrieved successfully"),
                    @ApiResponse(code = 404, message = "No movie retrieved")
            }
    )
    public ResponseEntity<Movie> getMovieById(@PathVariable String movieId) {
        Movie movie = moviesService.getMovie(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation(value = "POST method to add new movie", notes = "Returns new movie Id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Movie added successfully"),
                    @ApiResponse(code = 400, message = "Invalid movie details provided")
            }
    )
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String res = moviesService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    @ApiOperation(value = "PUT method to update existing movie", notes = "Returns updated movie")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Movie updated successfully"),
                    @ApiResponse(code = 404, message = "No movie retrieved"),
                    @ApiResponse(code = 400, message = "Invalid movie details provided")
            }
    )
    public ResponseEntity<Movie> updateMovie(@PathVariable String movieId, @RequestBody Movie movie) {
        Movie res = moviesService.editMovie(movieId, movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}/actors")
    @ApiOperation(value = "GET all actors of a movie", notes = "Returns list of actors")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Actors retrieved successfully"),
                    @ApiResponse(code = 404, message = "No movie actors retrieved")
            }
    )
    public ResponseEntity<List<Actor>> getMovieActors(@PathVariable String movieId) {
        List<Actor> res = moviesService.getAllActors(movieId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{movieId}/reviews")
    @ApiOperation(value = "GET all reviews of a movie", notes = "Returns list of actors")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Reviews retrieved successfully"),
                    @ApiResponse(code = 404, message = "No movie reviews retrieved")
            }
    )
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable String movieId) {
        List<Review> res = reviewsService.getAllReviews(movieId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/{movieId}/reviews")
    @ApiOperation(value = "POST method to add review of a movie", notes = "Returns new review Id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Reviews added successfully"),
                    @ApiResponse(code = 400, message = "Invalid review details provided")
            }
    )
    public ResponseEntity<String> addReview(@PathVariable String movieId, @RequestBody Review review) {
        String res = reviewsService.addReview(movieId, review);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
