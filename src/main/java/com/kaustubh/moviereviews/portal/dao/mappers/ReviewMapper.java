package com.kaustubh.moviereviews.portal.dao.mappers;

import com.kaustubh.moviereviews.portal.entities.ReviewEntity;
import com.kaustubh.moviereviews.portal.models.Review;

public class ReviewMapper {

    private ReviewEntity entity;
    private Review model;

    public ReviewMapper (Review model) {
        this.model = model;
    }

    public ReviewMapper (ReviewEntity entity) {
        this.entity = entity;
    }

    public Review mapToModel (Review model) {
        model.setReviewId(entity.getReviewId());
        model.setReviewBody(entity.getReviewBody());
        model.setReviewRating(entity.getReviewRating());
        model.setReviewTitle(entity.getReviewTitle());

        return model;
    }

    public ReviewEntity mapToEntity (ReviewEntity entity) {
        entity.setReviewId(model.getReviewId());
        entity.setReviewBody(model.getReviewBody());
        entity.setReviewRating(model.getReviewRating());
        entity.setReviewTitle(model.getReviewTitle());

        return entity;
    }
}
