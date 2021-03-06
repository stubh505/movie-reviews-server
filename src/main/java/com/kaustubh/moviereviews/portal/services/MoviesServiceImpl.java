package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.MoviesDAO;
import com.kaustubh.moviereviews.portal.exceptions.InvalidMovieException;
import com.kaustubh.moviereviews.portal.exceptions.MovieNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoviesServiceImpl implements MoviesService {

    private final Logger logger = LoggerFactory.getLogger(MoviesServiceImpl.class);
    @Autowired
    private MoviesDAO moviesDAO;
    @Autowired
    private Environment environment;

    @Override
    public String addMovie(Movie movie) {
        if (movie == null)
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        logger.info("Adding new movie : " + movie);
        String res = moviesDAO.addMovie(movie);

        if (res == null || res.equals(""))
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        logger.info("Movie Added with id " + res);
        return res;
    }

    @Override
    public Movie getMovie(String movieId) {
        if (movieId == null || movieId.equals(""))
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        logger.info("Retrieving Movie with id " + movieId);
        Movie res = moviesDAO.getMovie(movieId);

        if (res == null)
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        logger.info("Retrieved movie : " + res);
        return res;
    }

    @Override
    public List<Movie> getMoviesOfActor(String actorId) {
        if (actorId == null || actorId.equals(""))
            throw new InvalidMovieException(environment.getProperty("ACTOR_INVALID"));

        logger.info("Getting all movies of actor " + actorId + "...");
        List<Movie> res = moviesDAO.getMoviesOfActor(actorId);

        if (res == null || res.isEmpty())
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        logger.info("All movies of actor " + actorId + " retrieved");
        return res;
    }

    @Override
    public List<Movie> getAll() {
        logger.info("Getting all movies...");
        List<Movie> res = moviesDAO.getAll();

        if (res == null || res.isEmpty())
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        logger.info("All movies retrieved");
        return res;
    }

    @Override
    public Movie editMovie(String movieId, Movie movie) {
        if (movieId == null || movieId.equals("") || movie == null)
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        logger.info("Editing movie with id : " + movieId);
        logger.debug("Updating with new details : " + movie);
        Movie res = moviesDAO.editMovie(movieId, movie);

        if (res == null)
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        logger.info("Movie with id " + movieId + " updated");
        return res;
    }

    @Override
    public List<Actor> getAllActors(String movieId) {
        if (movieId == null || movieId.equals(""))
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        logger.info("Getting all actors for movie with id " + movieId + "...");
        List<Actor> res = moviesDAO.getAllActors(movieId);

        if (res == null || res.isEmpty())
            throw new MovieNotFoundException(environment.getProperty("ACTOR_404"));

        logger.info("All actors retrieved");
        return res;
    }
}
