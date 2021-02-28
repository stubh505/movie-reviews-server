package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.dao.mappers.ActorMapper;
import com.kaustubh.moviereviews.portal.entities.ActorEntity;
import com.kaustubh.moviereviews.portal.exceptions.ActorNotFoundException;
import com.kaustubh.moviereviews.portal.models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ActorsDAOImpl implements ActorsDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private Environment environment;

    @Override
    public Actor getActorByName(String name) {
        Query query = entityManager.createQuery("select a from ActorEntity a where a.name = :name");
        query.setParameter("name", name);
        ActorEntity entity = (ActorEntity) query.getResultList().get(0);

        if (entity == null)
            throw new ActorNotFoundException(environment.getProperty("ACTOR_404"));

        Actor actor = new ActorMapper(entity).mapToModel(new Actor());
        return actor;
    }

    @Override
    public String addActor(Actor actor) {
        ActorEntity entity = new ActorMapper(actor).mapToEntity(new ActorEntity());
        entityManager.persist(entity);
        return entity.getActorId();
    }

    @Override
    public Actor editActor(String actorId, Actor actor) {
        ActorEntity entity = entityManager.find(ActorEntity.class, actorId);

        if (entity == null)
            throw new ActorNotFoundException(environment.getProperty("ACTOR_404"));

        entity = new ActorMapper(actor).mapToEntity(entity);
        entityManager.persist(entity);
        actor.setActorId(entity.getActorId());

        return actor;
    }
}
