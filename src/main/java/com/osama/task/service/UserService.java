package com.osama.task.service;

import com.osama.task.connectionManger.ConnectionManger;
import com.osama.task.dao.UserDAOImpl;
import com.osama.task.entities.User;
import com.osama.task.exceptions.DAOException;
import com.osama.task.exceptions.ServiceException;

/**
 * Service class for user entity.
 *
 * @author Osama Alfaqeeh
 * @see User
 * @see UserDAOImpl
 * @see ConnectionManger
 */
public class UserService {

    /**
     * The method returns authorized user.
     *
     * @param userName    the user's user name.
     * @return the User.
     * @throws ServiceException object if execution of method is failed.
     */
    public User login(String userName,String password) throws ServiceException {
        try  {

            UserDAOImpl userDAO = new UserDAOImpl(ConnectionManger.creatConnection());

            User user = userDAO.getByUserName(userName);

            if (user != null) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
                return null;

        } catch (DAOException exception) {
            throw new ServiceException("Exception during login operation.", exception);
        }
    }

}
