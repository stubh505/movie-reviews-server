package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.exceptions.ReviewNotFoundException;
import com.kaustubh.moviereviews.portal.models.Review;

import java.util.List;

public interface ReviewsDAO {

    /**
     * Method to retrieve all reviews for given movie
     *
     * @param movieId movie id
     * @return list of reviews
     * @throws ReviewNotFoundException if review does not exist
     */
    List<Review> getAllReviews(String movieId);

    /**
     * Method to retrieve all reviews for given user
     *
     * @param userId user id
     * @return list of reviews
     * @throws ReviewNotFoundException if review does not exist
     */
    List<Review> getUserReviews(String userId);

    /**
     * Method to add new review
     *
     * @param review review details
     * @return persisted review id
     */
    String addReview(Review review);

    /**
     * Method to edit existing review for given movie
     *
     * @param reviewId review id
     * @return updated review
     * @throws ReviewNotFoundException if review does not exist
     */
    Review editReview(String reviewId, Review review);

    /**
     * Method to delete existing review for given movie
     *
     * @param reviewId review id
     * @return deleted review id
     * @throws ReviewNotFoundException if review does not exist
     */
    String deleteReview(String reviewId);
}
