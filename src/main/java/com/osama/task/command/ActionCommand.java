package com.osama.task.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface Action commands.
 *
 * @author Osama Alfaqeeh
 */
public interface ActionCommand {
    /**
     * parameters.
     */
    String COMMAND_PARAMETER = "command";
    String NAME_PARAMETER = "name";
    String COUNTRY_PARAMETER = "country";
    String USER_NAME_PARAMETER = "user_name";
    String PASSWORD_PARAMETER= "password";


    /**
     * Attributes.
     */
    String MESSAGE_ATTRIBUTE = "message";
    String LIST_ATTRIBUTE = "list";
    String USER_ATTRIBUTE = "user";

     Page execute(HttpServletRequest request);
}
