package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.exceptions.EmailExistsException;
import com.kaustubh.moviereviews.portal.exceptions.UserNameExistsException;
import com.kaustubh.moviereviews.portal.exceptions.UserNotFoundException;
import com.kaustubh.moviereviews.portal.models.User;

public interface UsersDAO {

    /**
     * Method to get User by Id
     *
     * @param userId user id
     * @return user details
     * @throws UserNotFoundException when user does not exist
     */
    User getUser(String userId);

    /**
     * Method to register new User
     *
     * @param user user details
     * @return persisted user id
     */
    String addUser(User user);

    /**
     * Method to edit existing User by Id
     *
     * @param userId user id
     * @param user   updated user details
     * @return updated user details
     * @throws UserNotFoundException when user does not exist
     */
    User editUser(String userId, User user);

    /**
     * Method to login existing User by username
     *
     * @param userName user username
     * @param password user password
     * @return updated user details
     * @throws UserNotFoundException   when user does not exist
     * @throws UserNameExistsException when user name is already registered
     */
    User loginUserByUserName(String userName, String password);

    /**
     * Method to login existing User by email
     *
     * @param email    user email
     * @param password user password
     * @return updated user details
     * @throws UserNotFoundException when user does not exist
     * @throws EmailExistsException  when email is already registered
     */
    User loginUserByEmail(String email, String password);
}
