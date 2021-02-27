package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.models.Movie;

import java.util.List;

public interface MoviesDAO {
    String addMovie(Movie movie);
    Movie getMovie(String movieId);
    List<Movie> getAll();
    Movie editMovie(String movieId, Movie movie);
}
