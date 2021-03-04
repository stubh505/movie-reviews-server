package com.kaustubh.moviereviews.portal.entities;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class IdGen implements IdentifierGenerator, Configurable {

    private static final String PREFIX = "sequence_prefix";
    private static final String ENTITY = "entity_name";
    private String prefix;
    private String entity;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Connection connection = sharedSessionContractImplementor.connection();

        try {
            PreparedStatement preparedStatement;
            ResultSet set;
            String randomId;
            do {
                randomId = prefix + (int) (Math.round(Double.parseDouble((Math.random() * 99999 + 10000) + "")));
                preparedStatement = connection.prepareStatement("select * from " + entity + " where " + entity + "_id=?");
                preparedStatement.setString(1, randomId);
                set = preparedStatement.executeQuery();
            } while (set.next());

            return randomId;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        entity = properties.getProperty(ENTITY);
        prefix = properties.getProperty(PREFIX);
    }
}
