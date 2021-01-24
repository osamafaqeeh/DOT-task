package com.osama.task.connectionManger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Class of dao level to work with connection.
 *
 * @author Osama Alfaqeeh
 * @see Connection
 */
public class ConnectionManger{

    private static final Logger LOGGER = Logger.getLogger(ConnectionManger.class.getName());

    /**
     * Static method for Create connection to chosen database using connection pool.
     */
    public static Connection creatConnection(){
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/dot_task");
            return dataSource.getConnection();
        }
        catch (SQLException | NamingException exception) {
            LOGGER.warning("Connection hasn't been created, SQL exception was detected during connection creating "+exception.getMessage());
        }
        return null;
    }

}
