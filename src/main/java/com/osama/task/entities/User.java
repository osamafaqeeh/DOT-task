package com.osama.task.entities;


/**
 * This class describes user of application.
 *
 * @author Osama Alfaqeeh
 * @see Entity
 */
public class User extends Entity {

    private String userName;

    private String password;

    /**
     * Instantiates a new student.
     */
    public User() {
    }

    /**
     * Gets user's name.
     *
     * @return the user's name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user's name.
     *
     * @param userName the user's name.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user's password.
     *
     * @return the user's password.
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets password.
     *
     * @param password the password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
