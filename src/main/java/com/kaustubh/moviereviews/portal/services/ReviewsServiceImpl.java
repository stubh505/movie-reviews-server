package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.ReviewsDAO;
import com.kaustubh.moviereviews.portal.exceptions.InvalidReviewException;
import com.kaustubh.moviereviews.portal.exceptions.ReviewNotFoundException;
import com.kaustubh.moviereviews.portal.models.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsDAO reviewsDAO;

    @Autowired
    private Environment environment;

    private final Logger logger = LoggerFactory.getLogger(ReviewsServiceImpl.class);

    @Override
    public List<Review> getAllReviews(String movieId) {
        logger.info("Getting reviews for movie id " + movieId);
        List<Review> res = reviewsDAO.getAllReviews(movieId);

        if (res == null)
            throw new ReviewNotFoundException(environment.getProperty("REVIEW_404"));

        logger.info("Retrieved all reviews");
        return res;
    }

    @Override
    public List<Review> getUserReviews(String userId) {
        logger.info("Getting reviews for user id " + userId);
        List<Review> res = reviewsDAO.getUserReviews(userId);

        if (res == null)
            throw new ReviewNotFoundException(environment.getProperty("REVIEW_404"));

        logger.info("Retrieved all reviews");
        return res;
    }

    @Override
    public String addReview(String movieId, Review review) {
        logger.info("Adding new review to movie with id : " + movieId + "\n" + review);
        String res = reviewsDAO.addReview(review);

        if (res == null)
            throw new InvalidReviewException(environment.getProperty("REVIEW_INVALID"));

        logger.info("Persisted new review with id " + res);
        return res;
    }

    @Override
    public Review editReview(String reviewId, Review review) {
        logger.info("Editing review with id " + reviewId);
        Review res = reviewsDAO.editReview(reviewId, review);

        if (res == null)
            throw new InvalidReviewException(environment.getProperty("REVIEW_INVALID"));

        logger.info("Update review with details " + res);
        return res;
    }

    @Override
    public String deleteReview(String reviewId) {
        logger.info("Deleting review with id " + reviewId);
        String res = reviewsDAO.deleteReview(reviewId);

        if (res == null)
            throw new InvalidReviewException(environment.getProperty("REVIEW_NOT_DELETED"));

        logger.info("Update review with details " + res);
        return res;
    }
}
