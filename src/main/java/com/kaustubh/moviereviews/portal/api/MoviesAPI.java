package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesAPI {

    @GetMapping("/all")
    public List<Movie> getMovies () {
        return null;
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById (@PathVariable String movieId) {
        return null;
    }

    @PostMapping("/add")
    public String addMovie (@RequestBody String movie) {
        return null;
    }

    @PutMapping("/{movieId}")
    public Movie updateMovie (@PathVariable String movieId, @RequestBody Movie movie) {
        return null;
    }
}
