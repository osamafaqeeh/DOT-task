package com.osama.task.command.user;

import com.osama.task.command.ActionCommand;
import com.osama.task.command.Page;
import com.osama.task.entities.Student;
import com.osama.task.exceptions.ServiceException;
import com.osama.task.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.osama.task.command.Page.*;

/**
 * Command to show all student information.
 *
 * @author  Osama Alfaqeeh
 * @see StudentService
 * @see Student
 */
public class ShowAllStudentsInformationCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(ShowAllStudentsInformationCommand.class.getName());

    /**
     * Implementation of command to show all students information.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        try{
            StudentService customerService = new StudentService();
            List<Student> list = customerService.findAllStudent();

            HttpSession currentSession = request.getSession();
            currentSession.setAttribute(LIST_ATTRIBUTE,list);
            return new Page(SHOW_ALL_STUDENT_INFORMATION_PAGE_PATH,true);
        }
        catch (ServiceException exception){
            LOGGER.log(Level.INFO,exception.getMessage(),exception);
            return new Page(ERROR_PAGE_PATH,true);
        }
    }
}
