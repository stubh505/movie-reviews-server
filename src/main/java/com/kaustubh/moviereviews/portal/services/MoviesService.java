package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.models.Movie;

import java.util.List;

public interface MoviesService {
    String addMovie(Movie movie);
    Movie getMovie(String movieId);
    List<Movie> getAll();
    Movie editMovie(String movieId);
}
