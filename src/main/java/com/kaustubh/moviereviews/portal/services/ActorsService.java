package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.exceptions.ActorNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;

import java.util.List;

public interface ActorsService {

    /**
     * Service Method to retrieve actor by name
     *
     * @return list of actor body
     * @throws ActorNotFoundException when actor does not exist
     */
    List<Actor> getAll();

    /**
     * Service Method to retrieve actor by id
     *
     * @param actorId actor id
     * @return actor body
     * @throws ActorNotFoundException when actor does not exist
     */
    Actor getActorById(String actorId);

    /**
     * Service Method to retrieve actor by name
     *
     * @param name actor name
     * @return actor body
     * @throws ActorNotFoundException when actor does not exist
     */
    Actor getActorByName(String name);

    /**
     * Service Method to persist new Actor
     *
     * @param actor Actor details
     * @return persisted actor id
     */
    String addActor(Actor actor);

    /**
     * Service Method to edit existing Actor
     *
     * @param actorId actor id
     * @param actor   Actor details
     * @return updated actor
     */
    Actor editActor(String actorId, Actor actor);
}
