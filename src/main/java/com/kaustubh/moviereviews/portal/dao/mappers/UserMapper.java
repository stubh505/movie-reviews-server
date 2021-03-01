package com.kaustubh.moviereviews.portal.dao.mappers;

import com.kaustubh.moviereviews.portal.entities.UserEntity;
import com.kaustubh.moviereviews.portal.models.User;

public class UserMapper {

    private User model;
    private UserEntity entity;

    public UserMapper(User model) {
        this.model = model;
    }

    public UserMapper(UserEntity entity) {
        this.entity = entity;
    }

    public User mapToModel(User model) {
        model.setName(entity.getName());
        model.setDateOfBirth(entity.getDateOfBirth());
        model.setEmail(entity.getEmail());
        model.setUserId(entity.getUserId());
        model.setPassword(null);
        model.setUserName(entity.getUserName());
        model.setUserType(entity.getUserType());
        model.setReviewCount(entity.getReviewCount());
        model.setDateOfJoining(entity.getDateOfJoining());

        return model;
    }

    public UserEntity mapToEntity(UserEntity entity) {
        entity.setName(model.getName());
        entity.setDateOfBirth(model.getDateOfBirth());
        entity.setEmail(model.getEmail());
        entity.setUserId(model.getUserId());
        entity.setUserName(model.getUserName());
        entity.setUserType(model.getUserType());
        entity.setReviewCount(model.getReviewCount());
        entity.setDateOfJoining(model.getDateOfJoining());

        return entity;
    }
}
