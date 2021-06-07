package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.ActorsDAO;
import com.kaustubh.moviereviews.portal.exceptions.ActorNotFoundException;
import com.kaustubh.moviereviews.portal.exceptions.InvalidActorException;
import com.kaustubh.moviereviews.portal.models.Actor;
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
public class ActorServiceTest {

    @Mock
    ActorsDAO actorsDAO;

    @Mock
    Environment environment;

    @InjectMocks
    ActorsService actorsService = new ActorsServiceImpl();

    @Test
    public void getAllValidTest () {
        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor());
        Mockito.when(actorsDAO.getAll()).thenReturn(actors);
        List<Actor> res = actorsService.getAll();

        Assert.assertNotNull(res);
    }

    @Test
    public void getAllValidTestNoResult () {
        List<Actor> actors = new ArrayList<>();
        Mockito.when(actorsDAO.getAll()).thenReturn(actors);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ActorNotFoundException.class, () -> actorsService.getAll());
    }

    @Test
    public void getAllValidTestNull () {
        Mockito.when(actorsDAO.getAll()).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ActorNotFoundException.class, () -> actorsService.getAll());
    }

    @Test
    public void getActorByIdValidTest () {
        Mockito.when(actorsDAO.getActorById(Mockito.anyString())).thenReturn(new Actor());
        Actor res = actorsService.getActorById("id");

        Assert.assertNotNull(res);
    }

    @Test
    public void getActorByIdValidTestNoResult () {
        Mockito.when(actorsDAO.getActorById(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ActorNotFoundException.class, () -> actorsService.getActorById("id"));
    }

    @Test
    public void getActorByNameValidTest () {
        Mockito.when(actorsDAO.getActorByName(Mockito.anyString())).thenReturn(new Actor());
        Actor res = actorsService.getActorByName("NAME");

        Assert.assertNotNull(res);
    }

    @Test
    public void getActorByNameValidTestNoResult () {
        Mockito.when(actorsDAO.getActorByName(Mockito.anyString())).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(ActorNotFoundException.class, () -> actorsService.getActorByName("NAME"));
    }

    @Test
    public void addActorValidTest () {
        Mockito.when(actorsDAO.addActor(Mockito.any(Actor.class))).thenReturn("actors");
        String res = actorsService.addActor(new Actor());

        Assert.assertNotNull(res);
    }

    @Test
    public void addActorValidTestNoResult () {
        Mockito.when(actorsDAO.addActor(Mockito.any(Actor.class))).thenReturn("");
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidActorException.class, () -> actorsService.addActor(new Actor()));
    }

    @Test
    public void addActorValidTestNull () {
        Mockito.when(actorsDAO.addActor(Mockito.any(Actor.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidActorException.class, () -> actorsService.addActor(new Actor()));
    }

    @Test
    public void addActorInvalidTestNull () {
        Mockito.when(actorsDAO.addActor(Mockito.any(Actor.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidActorException.class, () -> actorsService.addActor(null));
    }

    @Test
    public void editActorValidTest () {
        Mockito.when(actorsDAO.editActor(Mockito.anyString(), Mockito.any(Actor.class))).thenReturn(new Actor());
        Actor res = actorsService.editActor("A1001", new Actor());

        Assert.assertNotNull(res);
    }

    @Test
    public void editActorValidTestNoResult () {
        Mockito.when(actorsDAO.editActor(Mockito.anyString(), Mockito.any(Actor.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidActorException.class, () -> actorsService.editActor("A1001", new Actor()));
    }

    @Test
    public void editActorValidTestNull () {
        Mockito.when(actorsDAO.editActor(Mockito.anyString(), Mockito.any(Actor.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidActorException.class, () -> actorsService.editActor("A1001", new Actor()));
    }

    @Test
    public void editActorInvalidTestNull () {
        Mockito.when(actorsDAO.editActor(Mockito.anyString(), Mockito.any(Actor.class))).thenReturn(null);
        Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("Exception");

        Assert.assertThrows(InvalidActorException.class, () -> actorsService.editActor("A1001", null));
    }
}
