package com.kaustubh.moviereviews.portal.entities;

import com.kaustubh.moviereviews.portal.enums.ReviewRating;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GenericGenerator(
            name = "idGen",
            strategy = "com.kaustubh.moviereviews.portal.entities.IdGen",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "entity_name",
                            value = "review"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix",
                            value = "R")
            })
    @GeneratedValue(generator = "idGen")
    private String reviewId;
    @Column(length = 100)
    private String reviewTitle;
    @Column(length = 2000)
    private String reviewBody;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "review_rating_type")
    @Type(type = "pgsql_enum")
    private ReviewRating reviewRating;
    @ManyToOne(cascade = CascadeType.ALL)
    private MoviesEntity movie;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;

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

    public MoviesEntity getMovie() {
        return movie;
    }

    public void setMovie(MoviesEntity movie) {
        this.movie = movie;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
