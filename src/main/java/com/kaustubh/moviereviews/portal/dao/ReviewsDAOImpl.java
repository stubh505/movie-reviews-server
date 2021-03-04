package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.dao.mappers.ReviewMapper;
import com.kaustubh.moviereviews.portal.dao.mappers.UserMapper;
import com.kaustubh.moviereviews.portal.entities.MoviesEntity;
import com.kaustubh.moviereviews.portal.entities.ReviewEntity;
import com.kaustubh.moviereviews.portal.entities.UserEntity;
import com.kaustubh.moviereviews.portal.exceptions.ReviewNotFoundException;
import com.kaustubh.moviereviews.portal.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewsDAOImpl implements ReviewsDAO {

    @Autowired
    MoviesDAO moviesDAO;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private Environment environment;

    @Override
    public List<Review> getAllReviews(String movieId) {
        Query query = entityManager.createQuery("select r for ReviewEntity r where r.movie.movieId = :movie");
        query.setParameter("movie", movieId);
        List<ReviewEntity> reviewEntities = query.getResultList();

        if (reviewEntities == null || reviewEntities.isEmpty())
            throw new ReviewNotFoundException(environment.getProperty("REVIEW_404"));

        List<Review> reviews = new ArrayList<>();

        for (ReviewEntity entity : reviewEntities) {
            reviews.add(new ReviewMapper(entity).mapToModel(new Review()));
        }

        return reviews;
    }

    @Override
    public List<Review> getUserReviews(String userId) {
        Query query = entityManager.createQuery("select r for ReviewEntity r where r.user.userId = :user");
        query.setParameter("user", userId);
        List<ReviewEntity> reviewEntities = query.getResultList();

        if (reviewEntities == null || reviewEntities.isEmpty())
            throw new ReviewNotFoundException(environment.getProperty("REVIEW_404"));

        List<Review> reviews = new ArrayList<>();

        for (ReviewEntity entity : reviewEntities) {
            reviews.add(new ReviewMapper(entity).mapToModel(new Review()));
        }

        return reviews;
    }

    @Override
    public String addReview(Review review) {
        ReviewEntity entity = new ReviewMapper(review).mapToEntity(new ReviewEntity());
        MoviesEntity moviesEntity = entityManager.find(MoviesEntity.class, review.getMovie().getMovieId());
        UserEntity userEntity = new UserMapper(review.getUser()).mapToEntity(new UserEntity());
        userEntity.setReviewCount(userEntity.getReviewCount() + 1);
        String[] reviews = moviesEntity.getReviews().split("\\|");
        String r = "|" + (Integer.parseInt(reviews[1]) + 1);
        r = (Integer.parseInt(reviews[0]) + review.getReviewRating().ordinal()) + r;
        moviesEntity.setReviews(r);
        entity.setMovie(moviesEntity);
        entity.setUser(userEntity);

        entityManager.persist(entity);
        return entity.getReviewId();
    }

    @Override
    public Review editReview(String reviewId, Review review) {
        ReviewEntity entity = entityManager.find(ReviewEntity.class, reviewId);

        if (entity == null)
            throw new ReviewNotFoundException(environment.getProperty("REVIEW_404"));

        MoviesEntity moviesEntity = entity.getMovie();
        String[] reviews = moviesEntity.getReviews().split("\\|");
        String r = "|" + (Integer.parseInt(reviews[1]));
        r = (Integer.parseInt(reviews[0]) - entity.getReviewRating().ordinal() + review.getReviewRating().ordinal()) + r;
        moviesEntity.setReviews(r);
        entityManager.persist(moviesEntity);

        entity = new ReviewMapper(review).mapToEntity(entity);
        entityManager.persist(entity);
        review.setReviewId(entity.getReviewId());

        return review;
    }

    @Override
    public String deleteReview(String reviewId) {
        ReviewEntity entity = entityManager.find(ReviewEntity.class, reviewId);

        if (entity == null)
            throw new ReviewNotFoundException(environment.getProperty("REVIEW_404"));

        MoviesEntity moviesEntity = entity.getMovie();
        String[] reviews = moviesEntity.getReviews().split("\\|");
        String r = "|" + (Integer.parseInt(reviews[1]) - 1);
        r = (Integer.parseInt(reviews[0]) - entity.getReviewRating().ordinal()) + r;
        moviesEntity.setReviews(r);
        entityManager.persist(moviesEntity);

        entity.setUser(null);
        entity.setMovie(null);
        entityManager.remove(entity);
        return entity.getReviewId();
    }
}
