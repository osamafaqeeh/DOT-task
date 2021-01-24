package com.osama.task.dao;


import com.osama.task.entities.User;
import com.osama.task.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImpl extends AbstractDAOImpl<User> {

    /**
     * Common queries.
     */
    private static final String SELECT_ALL_QUERY = "SELECT * FROM dot_task.user";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM dot_task.user WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM dot_task.user WHERE id = ?";
    private static final String INSERT_ENTITY_QUERY = "INSERT INTO dot_task.user (user_name, password) VALUES (?,?)";
    private static final String UPDATE_ENTITY_QUERY = "UPDATE dot_task.user SET user_name = ?, password = ? WHERE id = ?";
    private static final String SELECT_BY_USER_NAME = "SELECT * FROM dot_task.user WHERE user_name = ?";
    private static final String USER_NAME_COLUMN_LABEL = "user_name";
    private static final String PASSWORD_COLUMN_LABEL = "password";


    /**
     * Instantiates a new AbstractDAOImpl.
     *
     * @param connection the connection to database.
     */
    public UserDAOImpl(Connection connection) {
        super(connection);
    }

    public User getByUserName(String userName) throws DAOException {
        String sqlQuery = SELECT_BY_USER_NAME;

        try (PreparedStatement preparedStatement = prepareStatementForQuery(sqlQuery, userName)) {
            User entity = null;

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = buildEntity(resultSet);
            }

            return entity;
        } catch (SQLException exception) {
            throw new DAOException(exception.getMessage(), exception);
        }
    }

    /**
     * This method gets user's parameters.
     *
     * @param entity the entity.
     * @return List object with parameters.
     */
    @Override
    protected List<String> getEntityParameters(User entity) {
        List<String> parameters = new ArrayList<>();

        String name = entity.getUserName();
        parameters.add(name);

        String password = entity.getPassword();
        parameters.add(password);

        return parameters;

    }

    /**
     * This method builds User from ResultSet object.
     *
     * @param resultSet the result set of statement.
     * @return the User.
     * @throws DAOException object if execution of query is failed.
     */
    @Override
    protected User buildEntity(ResultSet resultSet) throws DAOException {
        try {
            User user = new User();

            int id = resultSet.getInt(ID_COLUMN_LABEL);
            user.setId(id);

            String userName = resultSet.getString(USER_NAME_COLUMN_LABEL);
            user.setUserName(userName);

            String password = resultSet.getString(PASSWORD_COLUMN_LABEL);
            user.setPassword(password);

            return user;
        } catch (SQLException exception) {
            throw new DAOException(exception);
        }

    }

    /**
     * This method initialize queries for common operations.
     *
     * @return Map object with queries.
     */
    @Override
    protected Map<String, String> initializeCommonQueries() {
        Map<String, String> commonQueries = new HashMap<>();

        commonQueries.put(SELECT_ALL_QUERY_KEY, SELECT_ALL_QUERY);
        commonQueries.put(SELECT_BY_ID_QUERY_KEY, SELECT_BY_ID_QUERY);
        commonQueries.put(DELETE_BY_ID_QUERY_KEY, DELETE_BY_ID_QUERY);
        commonQueries.put(INSERT_ENTITY_QUERY_KEY, INSERT_ENTITY_QUERY);
        commonQueries.put(UPDATE_ENTITY_QUERY_KEY, UPDATE_ENTITY_QUERY);

        return commonQueries;
    }
}
