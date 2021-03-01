package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.exceptions.MovieNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;

import java.util.List;

public interface MoviesDAO {

    /**
     * Method to persist new Movie
     *
     * @param movie Movie object
     * @return movieId
     */
    String addMovie(Movie movie);

    /**
     * Method to retrieve movie by id
     *
     * @param movieId movie id
     * @return movie
     */
    Movie getMovie(String movieId);

    /**
     * Method to return all movies
     *
     * @return List of Movies
     */
    List<Movie> getAll();

    /**
     * Method to return all movies
     *
     * @param name actor name
     * @return List of Movies
     */
    List<Movie> getMoviesOfActor(String name);

    /**
     * Method to update details of existing movie
     *
     * @param movieId movie id
     * @param movie   new movie body
     * @return persisted movie
     * @throws MovieNotFoundException when movie not found
     */
    Movie editMovie(String movieId, Movie movie);

    /**
     * Method to retrieve actors of existing movie
     *
     * @param movieId movie id
     * @return list of actors
     * @throws MovieNotFoundException when movie not found
     */
    List<Actor> getAllActors(String movieId);
}
