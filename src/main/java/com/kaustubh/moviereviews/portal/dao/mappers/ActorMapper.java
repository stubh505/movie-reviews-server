package com.kaustubh.moviereviews.portal.dao.mappers;

import com.kaustubh.moviereviews.portal.entities.ActorEntity;
import com.kaustubh.moviereviews.portal.models.Actor;

public class ActorMapper {

    private ActorEntity entity;
    private Actor model;

    public ActorMapper (ActorEntity entity) {
        this.entity = entity;
    }

    public ActorMapper (Actor model) {
        this.model = model;
    }

    public Actor mapToModel (Actor model) {
        model.setActorId(entity.getActorId());
        model.setCountry(entity.getCountry());
        model.setDateOfBirth(entity.getDateOfBirth());
        model.setGender(entity.getGender());
        model.setImage(entity.getImage());
        model.setName(entity.getName());
        model.setMovieCount(entity.getMovieCount());

        return model;
    }

    public ActorEntity mapToEntity (ActorEntity entity) {
        entity.setCountry(model.getCountry());
        entity.setDateOfBirth(model.getDateOfBirth());
        entity.setGender(model.getGender());
        entity.setImage(model.getImage());
        entity.setName(model.getName());
        entity.setMovieCount(model.getMovieCount());

        return entity;
    }
}
