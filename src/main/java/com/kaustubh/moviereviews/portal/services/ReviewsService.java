package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.exceptions.InvalidReviewException;
import com.kaustubh.moviereviews.portal.exceptions.ReviewNotFoundException;
import com.kaustubh.moviereviews.portal.models.Review;

import java.util.List;

public interface ReviewsService {

    /**
     * Service Method to retrieve all reviews for given movie
     *
     * @param movieId movie id
     * @return list of reviews
     * @throws ReviewNotFoundException if review does not exist
     */
    List<Review> getAllReviews(String movieId);

    /**
     * Service Method to retrieve all reviews for given user
     *
     * @param userId user id
     * @return list of reviews
     * @throws ReviewNotFoundException if review does not exist
     */
    List<Review> getUserReviews(String userId);

    /**
     * Service Method to add new review
     *
     * @param movieId review movie id
     * @param review  review details
     * @return persisted review id
     * @throws InvalidReviewException if review details are invalid
     */
    String addReview(String movieId, Review review);

    /**
     * Service Method to edit existing review for given movie
     *
     * @param reviewId review id
     * @return updated review
     * @throws InvalidReviewException if review does not exist
     */
    Review editReview(String reviewId, Review review);

    /**
     * Service Method to delete existing review for given movie
     *
     * @param reviewId review id
     * @return deleted review id
     * @throws ReviewNotFoundException if review does not exist
     */
    String deleteReview(String reviewId);
}
