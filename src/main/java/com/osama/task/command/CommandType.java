package com.osama.task.command;

import com.osama.task.command.user.AddStudentCommand;
import com.osama.task.command.user.LoginCommand;
import com.osama.task.command.user.ShowAllStudentsInformationCommand;

/**
 * Types of commands.
 *
 * @author Osama Alfaqeeh
 * @see ActionCommand
 */
public enum  CommandType {

    SHOW_ALL_STUDENTS_INFORMATION{
        {
            this.command = new ShowAllStudentsInformationCommand();
        }
    },
    ADD_STUDENT{
        {
            this.command = new AddStudentCommand();
        }
    },
    LOGIN_COMMAND{
        {
            this.command = new LoginCommand();
        }
    };

    /**
     * Current command.
     */
    ActionCommand command;

    /**
     * Gets current commands.
     *
     * @return the current commands.
     */
    public ActionCommand getCurrentCommand(){
        return this.command;
    }
}
