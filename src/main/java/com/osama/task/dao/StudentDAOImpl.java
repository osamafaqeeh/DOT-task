package com.osama.task.dao;

import com.osama.task.entities.Student;
import com.osama.task.exceptions.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that provide access to the database and deal with Student entity.
 *
 * @author Osama ALfaqeeh
 * @see AbstractDAOImpl
 * @see Student
 */
public class StudentDAOImpl extends AbstractDAOImpl<Student> {

    /**
     * Common queries.
     */
    private static final String SELECT_ALL_QUERY = "SELECT * FROM dot_task.student";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM dot_task.student WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM dot_task.student WHERE id = ?";
    private static final String INSERT_ENTITY_QUERY = "INSERT INTO dot_task.student (name, country) VALUES (?,?)";
    private static final String UPDATE_ENTITY_QUERY = "UPDATE dot_task.student SET name = ?, country = ? WHERE id = ?";

    private static final String NAME_COLUMN_LABEL = "name";
    private static final String COUNTRY_COLUMN_LABEL = "country";

    /**
     * Instantiates a new AbstractDAOImpl.
     *
     * @param connection the connection to database.
     */
    public StudentDAOImpl(Connection connection) {
        super(connection);
    }

    /**
     * This method gets student's parameters.
     *
     * @param entity the entity.
     * @return List object with parameters.
     */
    @Override
    protected List<String> getEntityParameters(Student entity) {
        List<String> parameters = new ArrayList<>();

        String name = entity.getName();
        parameters.add(name);

        String country = entity.getCountry();
        parameters.add(country);

        return parameters;

    }

    /**
     * This method builds student from ResultSet object.
     *
     * @param resultSet the result set of statement.
     * @return the student.
     * @throws DAOException object if execution of query is failed.
     */
    @Override
    protected Student buildEntity(ResultSet resultSet) throws DAOException {
       try {
           Student student =new Student();

           int id = resultSet.getInt(ID_COLUMN_LABEL);
           student.setId(id);

           String name = resultSet.getString(NAME_COLUMN_LABEL);
           student.setName(name);

           String country = resultSet.getString(COUNTRY_COLUMN_LABEL);
           student.setCountry(country);

           return student;
       }
       catch (SQLException exception){
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
