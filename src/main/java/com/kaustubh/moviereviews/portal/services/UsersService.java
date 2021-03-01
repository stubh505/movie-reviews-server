package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.exceptions.UserNotFoundException;
import com.kaustubh.moviereviews.portal.models.User;

public interface UsersService {

    /**
     * Service Method to get User by Id
     *
     * @param userId user id
     * @return user details
     * @throws UserNotFoundException when user does not exist
     */
    User getUser(String userId);

    /**
     * Service Method to register new User
     *
     * @param user user details
     * @return persisted user id
     */
    String addUser(User user);

    /**
     * Service Method to edit existing User by Id
     *
     * @param userId user id
     * @param user   updated user details
     * @return updated user details
     * @throws UserNotFoundException when user does not exist
     */
    User editUser(String userId, User user);

    /**
     * Service Method to login existing User
     *
     * @param user user details
     * @return updated user details
     * @throws UserNotFoundException when user does not exist
     */
    User loginUser(User user);
}
