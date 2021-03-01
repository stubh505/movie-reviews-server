package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.exceptions.ActorNotFoundException;
import com.kaustubh.moviereviews.portal.exceptions.InvalidMovieException;
import com.kaustubh.moviereviews.portal.exceptions.MovieNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;

import java.util.List;

public interface MoviesService {
    /**
     * Service Method to persist new Movie
     *
     * @param movie Movie object
     * @return movieId
     * @throws InvalidMovieException when movie details invalid
     */
    String addMovie(Movie movie);

    /**
     * Service Method to retrieve movie by id
     *
     * @param movieId movie id
     * @return movie
     * @throws MovieNotFoundException when movie not found
     */
    Movie getMovie(String movieId);

    /**
     * Service Method to return all movies
     *
     * @param name name of actor
     * @return List of Movies
     * @throws MovieNotFoundException when movie not found
     */
    List<Movie> getMoviesOfActor(String name);

    /**
     * Service Method to return all movies
     *
     * @return List of Movies
     * @throws MovieNotFoundException when movie not found
     */
    List<Movie> getAll();

    /**
     * Service Method to update details of existing movie
     *
     * @param movieId movie id
     * @param movie   new movie body
     * @return persisted movie
     * @throws MovieNotFoundException when movie not found
     * @throws InvalidMovieException  when movie details invalid
     */
    Movie editMovie(String movieId, Movie movie);

    /**
     * Service Method to retrieve actors of existing movie
     *
     * @param movieId movie id
     * @return list of actors
     * @throws ActorNotFoundException if actor does not exist
     */
    List<Actor> getAllActors(String movieId);
}
