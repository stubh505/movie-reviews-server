package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.dao.mappers.MovieMapper;
import com.kaustubh.moviereviews.portal.entities.MoviesEntity;
import com.kaustubh.moviereviews.portal.exceptions.MovieNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesDAOImpl implements MoviesDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private Environment environment;

    @Autowired
    private ActorsDAO actorsDAO;

    @Override
    public String addMovie(Movie movie) {
        MoviesEntity moviesEntity = new MovieMapper(movie).mapToEntity(new MoviesEntity());
        entityManager.persist(moviesEntity);
        return moviesEntity.getMovieId();
    }

    @Override
    public Movie getMovie(String movieId) {
        MoviesEntity entity = entityManager.find(MoviesEntity.class, movieId);

        if (entity == null)
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        Movie movie = new MovieMapper(entity).mapToModel(new Movie());
        List<Actor> actors = new ArrayList<>();
        String[] names = entity.getCastActor().split("\\|");

        for (String name : names) {
            actors.add(actorsDAO.getActorByName(name));
        }

        movie.setCast(actors);
        return movie;
    }

    @Override
    public List<Movie> getAll() {
        Query query = entityManager.createQuery("select m from MoviesEntity m");
        List<MoviesEntity> moviesEntities = query.getResultList();
        List<Movie> movies = new ArrayList<>();

        for (MoviesEntity entity : moviesEntities) {
            movies.add(new MovieMapper(entity).mapToModel(new Movie()));
        }

        return movies;
    }

    @Override
    public List<Movie> getMoviesOfActor(String actorId) {
        Query query = entityManager.createQuery("select m from MoviesEntity m where m.castActor like :name");
        query.setParameter("name", "%" + actorId + "%");
        List<MoviesEntity> moviesEntities = query.getResultList();
        List<Movie> movies = new ArrayList<>();

        for (MoviesEntity entity : moviesEntities) {
            movies.add(new MovieMapper(entity).mapToModel(new Movie()));
        }

        return movies;
    }

    @Override
    public Movie editMovie(String movieId, Movie movie) {
        MoviesEntity entity = entityManager.find(MoviesEntity.class, movieId);

        if (entity == null)
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        entity = new MovieMapper(movie).mapToEntity(entity);
        entityManager.persist(entity);
        movie.setMovieId(entity.getMovieId());
        return movie;
    }

    @Override
    public List<Actor> getAllActors(String movieId) {
        MoviesEntity entity = entityManager.find(MoviesEntity.class, movieId);

        if (entity == null)
            throw new MovieNotFoundException(environment.getProperty("MOVIE_404"));

        List<Actor> actors = new ArrayList<>();
        String[] ids = entity.getCastActor().split("\\|");

        for (String id : ids) {
            actors.add(actorsDAO.getActorById(id));
        }

        return actors;
    }
}
