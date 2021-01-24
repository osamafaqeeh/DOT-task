package com.osama.task.command.user;

import com.osama.task.command.ActionCommand;
import com.osama.task.command.Page;
import com.osama.task.entities.Student;
import com.osama.task.entities.User;
import com.osama.task.exceptions.ServiceException;
import com.osama.task.service.StudentService;
import com.osama.task.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.osama.task.command.Page.ERROR_PAGE_PATH;
import static com.osama.task.utils.MessageManager.LOGIN_ERROR_MESSAGE_KEY;

/**
 * Command for user log in.
 *
 * @author Osama Alfaqeeh
 * @see ActionCommand
 * @see HttpServletRequest
 * @see UserService
 */
public class LoginCommand implements ActionCommand {
    private final static Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());

    /**
     * Implementation of commands that user use to log in.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */

    @Override
    public Page execute(HttpServletRequest request) {

        String userName = request.getParameter(USER_NAME_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);

        UserService userService = new UserService();
        User user = null;
        try {
            user = userService.login(userName, password);
            if (user == null) {
                return new Page(Page.LOGIN_PAGE_PATH, false, LOGIN_ERROR_MESSAGE_KEY);
            }

            StudentService studentService = new StudentService();
            List<Student> students = studentService.findAllStudent();

            HttpSession currentSession = request.getSession();
            currentSession.setAttribute(USER_ATTRIBUTE, user);
            currentSession.setAttribute(LIST_ATTRIBUTE,students);

            return new Page(Page.SHOW_ALL_STUDENT_INFORMATION_PAGE_PATH, true);
        } catch (ServiceException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage(), ex);
            return new Page(ERROR_PAGE_PATH, true);
        }
    }
}
