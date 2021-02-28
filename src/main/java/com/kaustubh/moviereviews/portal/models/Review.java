package com.kaustubh.moviereviews.portal.models;

import com.kaustubh.moviereviews.portal.enums.ReviewRating;

public class Review {
    private String reviewId;
    private String reviewTitle;
    private String reviewBody;
    private ReviewRating reviewRating;
    private Movie movie;
    private User user;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public ReviewRating getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(ReviewRating reviewRating) {
        this.reviewRating = reviewRating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewBody='" + reviewBody + '\'' +
                ", reviewRating=" + reviewRating +
                '}';
    }
}
