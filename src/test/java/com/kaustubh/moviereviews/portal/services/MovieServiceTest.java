package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.MoviesDAO;
import com.kaustubh.moviereviews.portal.exceptions.*;
import com.kaustubh.moviereviews.portal.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {
    
    @Mock
    MoviesDAO moviesDAO;
    
    @Mock
    Environment environment;
    
    @InjectMocks
    MoviesService moviesService = new MoviesServiceImpl();

    @Test
    public void addMovieValidTest () {
        Mockito.when(moviesDAO.addMovie(Mockito.any(Movie.class))).thenReturn("movies");
        String res = moviesService.addMovie(new Movie());

        Assert.assertNotNull(res);
    }

    @Test
    public void addMovieValidTestNoResult () {
        Mockito.when(moviesDAO.addMovie(Mockito.any(Movie.class))).thenReturn("");
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidMovieException.class, () -> moviesService.addMovie(new Movie()));
    }

    @Test
    public void addMovieValidTestNull () {
        Mockito.when(moviesDAO.addMovie(Mockito.any(Movie.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidMovieException.class, () -> moviesService.addMovie(new Movie()));
    }

    @Test
    public void addMovieInvalidTestNull () {
        Mockito.when(moviesDAO.addMovie(Mockito.any(Movie.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidMovieException.class, () -> moviesService.addMovie(null));
    }

    @Test
    public void getAllValidTest () {
        List<Movie> movie = new ArrayList<>();
        movie.add(new Movie());
        Mockito.when(moviesDAO.getAll()).thenReturn(movie);
        List<Movie> res = moviesService.getAll();

        Assert.assertNotNull(res);
    }

    @Test
    public void getAllValidTestNoResult () {
        List<Movie> movie = new ArrayList<>();
        Mockito.when(moviesDAO.getAll()).thenReturn(movie);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getAll());
    }

    @Test
    public void getAllValidTestNull () {
        Mockito.when(moviesDAO.getAll()).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getAll());
    }

    @Test
    public void getMoviesOfActorValidTest () {
        List<Movie> movie = new ArrayList<>();
        movie.add(new Movie());
        Mockito.when(moviesDAO.getMoviesOfActor(Mockito.anyString())).thenReturn(movie);
        List<Movie> res = moviesService.getMoviesOfActor("A1001");

        Assert.assertNotNull(res);
    }

    @Test
    public void getMoviesOfActorValidTestNoResult () {
        List<Movie> movie = new ArrayList<>();
        Mockito.when(moviesDAO.getMoviesOfActor(Mockito.anyString())).thenReturn(movie);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getMoviesOfActor("A1001"));
    }

    @Test
    public void getMoviesOfActorValidTestNull () {
        Mockito.when(moviesDAO.getMoviesOfActor(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getMoviesOfActor("A1001"));
    }

    @Test
    public void getAllActorsValidTest () {
        List<Actor> movie = new ArrayList<>();
        movie.add(new Actor());
        Mockito.when(moviesDAO.getAllActors(Mockito.anyString())).thenReturn(movie);
        List<Actor> res = moviesService.getAllActors("A10001");

        Assert.assertNotNull(res);
    }

    @Test
    public void getAllActorsValidTestNoResult () {
        List<Actor> movie = new ArrayList<>();
        Mockito.when(moviesDAO.getAllActors("A10001")).thenReturn(movie);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getAllActors("A10001"));
    }

    @Test
    public void getAllActorsValidTestNull () {
        Mockito.when(moviesDAO.getAllActors("A10001")).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getAllActors("A10001"));
    }

    @Test
    public void getMovieValidTest () {
        Mockito.when(moviesDAO.getMovie(Mockito.anyString())).thenReturn(new Movie());
        Movie res = moviesService.getMovie("id");

        Assert.assertNotNull(res);
    }

    @Test
    public void getMovieValidTestNoResult () {
        Mockito.when(moviesDAO.getMovie(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(MovieNotFoundException.class, () -> moviesService.getMovie("id"));
    }

    @Test
    public void editMovieValidTest () {
        Mockito.when(moviesDAO.editMovie(Mockito.anyString(), Mockito.any(Movie.class))).thenReturn(new Movie());
        Movie res = moviesService.editMovie("A1001", new Movie());

        Assert.assertNotNull(res);
    }

    @Test
    public void editMovieValidTestNoResult () {
        Mockito.when(moviesDAO.editMovie(Mockito.anyString(), Mockito.any(Movie.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidMovieException.class, () -> moviesService.editMovie("A1001", new Movie()));
    }

    @Test
    public void editMovieValidTestNull () {
        Mockito.when(moviesDAO.editMovie(Mockito.anyString(), Mockito.any(Movie.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidMovieException.class, () -> moviesService.editMovie("A1001", new Movie()));
    }

    @Test
    public void editMovieInvalidTestNull () {
        Mockito.when(moviesDAO.editMovie(Mockito.anyString(), Mockito.any(Movie.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidMovieException.class, () -> moviesService.editMovie("A1001", null));
    }
}
