package com.kaustubh.moviereviews.portal.dao.mappers;

import com.kaustubh.moviereviews.portal.entities.MoviesEntity;
import com.kaustubh.moviereviews.portal.enums.Genre;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    private MoviesEntity entity;
    private Movie model;

    public MovieMapper(MoviesEntity entity) {
        this.entity = entity;
    }

    public MovieMapper(Movie model) {
        this.model = model;
    }

    public MoviesEntity mapToEntity(MoviesEntity entity) {
        entity.setName(model.getName());
        entity.setCountry(model.getCountry());
        entity.setDirector(model.getDirector());
        entity.setLanguage(model.getLanguage());
        entity.setLength(model.getLength());
        entity.setReleaseDate(model.getReleaseDate());
        entity.setPoster(model.getPoster());
        entity.setTrailer(model.getTrailer());
        entity.setRating(model.getRating());
        entity.setSynopsys(model.getSynopsys());
        StringBuilder s = new StringBuilder();
        for (Genre g : model.getGenre()) {
            s.append(g.name()).append("|");
        }
        entity.setGenre(s.substring(0, s.length() - 1));
        s = new StringBuilder();
        for (Actor a : model.getCast()) {
            s.append(a.getActorId()).append("|");
        }
        entity.setCastActor(s.substring(0, s.length() - 1));

        return entity;
    }

    public Movie mapToModel(Movie model) {
        model.setMovieId(entity.getMovieId());
        model.setName(entity.getName());
        model.setCountry(entity.getCountry());
        model.setDirector(entity.getDirector());
        model.setLanguage(entity.getLanguage());
        model.setLength(entity.getLength());
        model.setReleaseDate(entity.getReleaseDate());
        model.setPoster(entity.getPoster());
        model.setTrailer(entity.getTrailer());
        model.setRating(entity.getRating());
        String[] reviews = entity.getReviews().split("\\|");
        model.setReview(Integer.parseInt(reviews[0]) / Integer.parseInt(reviews[1]) + "");
        model.setReviewCount(reviews[1]);
        model.setSynopsys(entity.getSynopsys());
        List<Genre> genreList = new ArrayList<>();
        String[] gs = entity.getGenre().split("\\|");
        for (String g : gs) {
            genreList.add(Genre.valueOf(g));
        }
        model.setGenre(genreList);

        return model;
    }
}
