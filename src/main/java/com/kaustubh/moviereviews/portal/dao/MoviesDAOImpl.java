package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.dao.mappers.MovieMapper;
import com.kaustubh.moviereviews.portal.entities.MoviesEntity;
import com.kaustubh.moviereviews.portal.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesDAOImpl implements MoviesDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public String addMovie(Movie movie) {
        MoviesEntity moviesEntity = new MovieMapper(movie).mapToEntity(new MoviesEntity());
        entityManager.persist(moviesEntity);
        return moviesEntity.getMovieId();
    }

    @Override
    public Movie getMovie(String movieId) {
        MoviesEntity entity = entityManager.find(MoviesEntity.class, movieId);
        Movie movie = new MovieMapper(entity).mapToModel(new Movie());
        return movie;
    }

    @Override
    public List<Movie> getAll() {
        Query query = entityManager.createQuery("select m from MoviesEntity m");
        List<MoviesEntity> moviesEntities = query.getResultList();
        List<Movie> movies = new ArrayList<>();

        for (MoviesEntity entity:moviesEntities) {
            movies.add(new MovieMapper(entity).mapToModel(new Movie()));
        }

        return movies;
    }

    @Override
    public Movie editMovie(String movieId, Movie movie) {
        MoviesEntity entity = entityManager.find(MoviesEntity.class, movieId);
        entity = new MovieMapper(movie).mapToEntity(entity);
        entityManager.persist(entity);
        return movie;
    }
}
