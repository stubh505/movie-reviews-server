package com.kaustubh.moviereviews.portal.dao;

import com.kaustubh.moviereviews.portal.dao.mappers.UserMapper;
import com.kaustubh.moviereviews.portal.entities.UserEntity;
import com.kaustubh.moviereviews.portal.exceptions.EmailExistsException;
import com.kaustubh.moviereviews.portal.exceptions.UserNameExistsException;
import com.kaustubh.moviereviews.portal.exceptions.UserNotFoundException;
import com.kaustubh.moviereviews.portal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private Environment environment;

    @Override
    public User getUser(String userId) {
        UserEntity entity = entityManager.find(UserEntity.class, userId);

        if (entity == null)
            throw new UserNotFoundException(environment.getProperty("USER_404"));

        User user = new UserMapper(entity).mapToModel(new User());
        return user;
    }

    @Override
    public String addUser(User user) {
        UserEntity entity = new UserMapper(user).mapToEntity(new UserEntity());
        entityManager.persist(entity);
        return entity.getUserId();
    }

    @Override
    public User editUser(String userId, User user) {
        UserEntity entity = entityManager.find(UserEntity.class, userId);

        if (entity == null)
            throw new UserNotFoundException(environment.getProperty("USER_404"));

        entity = new UserMapper(user).mapToEntity(entity);
        entityManager.persist(entity);
        user.setUserId(entity.getUserId());
        return user;
    }

    @Override
    public User loginUserByUserName(String userName, String password) {
        if (checkUserNameExists(userName))
            throw new UserNameExistsException();

        return null;
    }

    @Override
    public User loginUserByEmail(String email, String password) {
        if (checkEmailExists(email))
            throw new EmailExistsException();

        return null;
    }

    private boolean checkEmailExists(String email) {
        Query query = entityManager.createQuery("select u from UserEntity u where u.email = :email");
        query.setParameter("email", email);

        UserEntity entity = (UserEntity) query.getResultList().get(0);

        return entity != null;
    }

    private boolean checkUserNameExists(String userName) {
        Query query = entityManager.createQuery("select u from UserEntity u where u.userName = :userName");
        query.setParameter("userName", userName);

        UserEntity entity = (UserEntity) query.getResultList().get(0);

        return entity != null;
    }
}
