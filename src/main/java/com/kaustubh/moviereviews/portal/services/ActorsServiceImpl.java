package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.ActorsDAO;
import com.kaustubh.moviereviews.portal.exceptions.ActorNotFoundException;
import com.kaustubh.moviereviews.portal.exceptions.InvalidActorException;
import com.kaustubh.moviereviews.portal.models.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class ActorsServiceImpl implements ActorsService {

    @Autowired
    private ActorsDAO actorsDAO;

    @Autowired
    private Environment environment;

    private final Logger logger = LoggerFactory.getLogger(ActorsServiceImpl.class);

    @Override
    public List<Actor> getAll() {
        logger.info("Getting all Actors...");
        List<Actor> res = actorsDAO.getAll();

        if (res == null || res.isEmpty())
            throw new ActorNotFoundException(environment.getProperty("ACTOR_404"));

        logger.info("Retrieved all Actors");
        return res;
    }

    @Override
    public Actor getActorById(String actorId) {
        logger.info("Getting actor with id " + actorId);
        Actor res = actorsDAO.getActorById(actorId);

        if (res == null)
            throw new ActorNotFoundException(environment.getProperty("ACTOR_404"));

        logger.info("Retrieved actor " + res);
        return res;
    }

    @Override
    public Actor getActorByName(String name) {
        logger.info("Getting actor with name " + name);
        Actor res = actorsDAO.getActorByName(name);

        if (res == null)
            throw new ActorNotFoundException(environment.getProperty("ACTOR_404"));

        logger.info("Retrieved actor " + res);
        return res;
    }

    @Override
    public String addActor(Actor actor) {
        logger.info("Adding new actor with details " + actor);
        String res = actorsDAO.addActor(actor);

        if (res == null || res.equals(""))
            throw new ActorNotFoundException(environment.getProperty("ACTOR_404"));

        logger.info("Persisted actor with id " + res);
        return res;
    }

    @Override
    public Actor editActor(String actorId, Actor actor) {
        logger.info("Editing actor with details " + actor);
        Actor res = actorsDAO.editActor(actorId, actor);

        if (res == null)
            throw new InvalidActorException(environment.getProperty("ACTOR_INVALID"));

        logger.info("Persisted actor with details " + res);
        return res;
    }
}
