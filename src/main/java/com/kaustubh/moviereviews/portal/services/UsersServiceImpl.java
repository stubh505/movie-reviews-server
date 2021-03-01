package com.kaustubh.moviereviews.portal.services;

import com.kaustubh.moviereviews.portal.dao.UsersDAO;
import com.kaustubh.moviereviews.portal.exceptions.InvalidUserException;
import com.kaustubh.moviereviews.portal.exceptions.UserNotFoundException;
import com.kaustubh.moviereviews.portal.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private Environment environment;

    private final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Override
    public User getUser(String userId) {
        if (userId == null || userId.equals(""))
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        logger.info("Retrieving user with id " + userId);
        User res = usersDAO.getUser(userId);

        if (res == null)
            throw new UserNotFoundException(environment.getProperty("USER_404"));

        logger.info("Retrieved user " + res);
        return res;
    }

    @Override
    public String addUser(User user) {
        if (user == null)
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        logger.info("Registering user with details " + user);
        String res = usersDAO.addUser(user);

        if (res == null)
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        logger.info("Registered user with id " + res);
        return res;
    }

    @Override
    public User editUser(String userId, User user) {
        if (user == null || userId == null || userId.equals(""))
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        logger.info("Updating user with details " + user);
        User res = usersDAO.editUser(userId, user);

        if (res == null)
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        logger.info("Updated user with id " + res);
        return res;
    }

    @Override
    public User loginUser(User user) {
        if (user == null)
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        logger.info("Logging user in...");
        User res;

        if (user.getPassword() == null || user.getPassword().equals(""))
            throw new InvalidUserException(environment.getProperty("USER_INVALID"));

        if (user.getEmail() == null || user.getEmail().equals("")) {
            if (user.getUserName() == null || user.getUserName().equals("")) {
                throw new InvalidUserException(environment.getProperty("USER_INVALID"));
            } else {
                res = usersDAO.loginUserByUserName(user.getUserName(), user.getPassword());
            }
        } else {
            res = usersDAO.loginUserByEmail(user.getEmail(), user.getPassword());
        }

        logger.info("Logged in user " + res);
        return res;
    }
}
