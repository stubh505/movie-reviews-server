package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.MoviesDAO;
import com.kaustubh.moviereviews.portal.exceptions.InvalidMovieException;
import com.kaustubh.moviereviews.portal.exceptions.MovieNotFoundException;
import com.kaustubh.moviereviews.portal.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesDAO moviesDAO;

    @Autowired
    private Environment environment;

    @Override
    public String addMovie(Movie movie) {
        String res = moviesDAO.addMovie(movie);

        if (res == null || res.equals(""))
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        return res;
    }

    @Override
    public Movie getMovie(String movieId) {
        Movie res = moviesDAO.getMovie(movieId);

        if (res == null)
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        return res;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> res = moviesDAO.getAll();

        if (res == null || res.isEmpty())
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        return res;
    }

    @Override
    public Movie editMovie(String movieId, Movie movie) {
        Movie res = moviesDAO.editMovie(movieId, movie);

        if (res == null)
            throw new InvalidMovieException(environment.getProperty("MOVIE_INVALID"));

        return res;
    }
}
