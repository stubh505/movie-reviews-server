package com.kaustubh.moviereviews.portal.models;

import com.kaustubh.moviereviews.portal.enums.ReviewRating;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Review Model")
public class Review {

    @ApiModelProperty("Generated Review Id")
    private String reviewId;
    @ApiModelProperty(value = "Review title within 100 characters", required = true)
    private String reviewTitle;
    @ApiModelProperty(value = "Review body within 2000 characters", required = true)
    private String reviewBody;
    @ApiModelProperty(value = "Review rating", required = true)
    private ReviewRating reviewRating;
    @ApiModelProperty(value = "Reference to movie reviewed", required = true)
    private Movie movie;
    @ApiModelProperty(value = "Reference to reviewer user", required = true)
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
