package com.kaustubh.moviereviews.portal.dao.mappers;

import com.kaustubh.moviereviews.portal.entities.ActorEntity;
import com.kaustubh.moviereviews.portal.entities.MoviesEntity;
import com.kaustubh.moviereviews.portal.entities.ReviewEntity;
import com.kaustubh.moviereviews.portal.entities.UserEntity;
import com.kaustubh.moviereviews.portal.enums.Genre;
import com.kaustubh.moviereviews.portal.enums.ReviewRating;
import com.kaustubh.moviereviews.portal.enums.UserType;
import com.kaustubh.moviereviews.portal.models.Actor;
import com.kaustubh.moviereviews.portal.models.Movie;
import com.kaustubh.moviereviews.portal.models.Review;
import com.kaustubh.moviereviews.portal.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapperTest {

    @Test
    public void movieMapperTestValidMapToEntity() {
        Actor a = new Actor();
        a.setActorId("A0001");

        Movie movie = new Movie();
        movie.setReviewCount("0|0");
        movie.setGenre(Arrays.asList(Genre.ACTION, Genre.FANTASY));
        movie.setCast(Collections.singletonList(a));
        MoviesEntity entity = new MovieMapper(movie).mapToEntity(new MoviesEntity());

        Assert.assertNotNull(entity);
    }

    @Test
    public void movieMapperTestValidMapToModel() {
        MoviesEntity entity = new MoviesEntity();
        entity.setReviews("0|0");
        entity.setGenre("ACTION|FANTASY");
        entity.setCastActor("A1001|A1002");
        Movie movie = new MovieMapper(entity).mapToModel(new Movie());

        Assert.assertNotNull(movie);
    }

    @Test
    public void actorMapperTestValidMapToModel() {
        ActorEntity entity = new ActorEntity();
        entity.setImage("0|0");
        entity.setName("ACTION|FANTASY");
        entity.setActorId("A1001|A1002");
        Actor model = new ActorMapper(entity).mapToModel(new Actor());

        Assert.assertNotNull(model);
    }

    @Test
    public void actorMapperTestValidMapToEntity() {
        Actor model = new Actor();
        model.setImage("0|0");
        model.setName("ACTION|FANTASY");
        model.setActorId("A1001|A1002");
        ActorEntity entity = new ActorMapper(model).mapToEntity(new ActorEntity());

        Assert.assertNotNull(entity);
    }

    @Test
    public void reviewMapperTestValidMapToEntity() {
        Review model = new Review();
        model.setReviewId("0|0");
        model.setReviewTitle("ACTION|FANTASY");
        model.setReviewRating(ReviewRating.THREE);
        ReviewEntity entity = new ReviewMapper(model).mapToEntity(new ReviewEntity());

        Assert.assertNotNull(entity);
    }

    @Test
    public void reviewMapperTestValidMapToModel() {
        ReviewEntity entity = new ReviewEntity();
        entity.setMovie(new MoviesEntity());
        entity.setReviewRating(ReviewRating.THREE);
        entity.setUser(new UserEntity());
        Review model = new ReviewMapper(entity).mapToModel(new Review());

        Assert.assertNotNull(model);
    }

    @Test
    public void userMapperTestValidMapToEntity() {
        User model = new User();
        model.setUserId("0|0");
        model.setUserType(UserType.ADMIN);
        model.setUserName("user1");
        UserEntity entity = new UserMapper(model).mapToEntity(new UserEntity());

        Assert.assertNotNull(entity);
    }

    @Test
    public void userMapperTestValidMapToModel() {
        UserEntity entity = new UserEntity();
        entity.setUserType(UserType.ADMIN);
        User model = new UserMapper(entity).mapToModel(new User());

        Assert.assertNotNull(model);
    }
}
