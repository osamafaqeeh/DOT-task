package com.osama.task.service;

import com.osama.task.connectionManger.ConnectionManger;
import com.osama.task.dao.StudentDAOImpl;
import com.osama.task.entities.Student;
import com.osama.task.exceptions.DAOException;
import com.osama.task.exceptions.ServiceException;

import java.util.List;

/**
 * Service class for Student entity.
 *
 * @author Osama Alfaqeeh
 * @see Student
 * @see StudentDAOImpl
 * @see ConnectionManger
 */
public class StudentService {

    /**
     * This method finds all student in database.
     *
     * @return List of students.
     * @throws ServiceException object if execution of method is failed.
     */
    public List<Student> findAllStudent() throws ServiceException {
        try{
            StudentDAOImpl studentDAO = new StudentDAOImpl(ConnectionManger.creatConnection());
            return studentDAO.selectAll();
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during find all student operation.", exception);
        }
    }

    /**
     * This method finds student by Id in database.
     *
     * @param studentId The student's id.
     * @return The Student.
     * @throws ServiceException object if execution of method is failed.
     */
    public Student findStudentById(int studentId) throws ServiceException {
        try{

            StudentDAOImpl studentDAO = new StudentDAOImpl(ConnectionManger.creatConnection());
            return studentDAO.selectEntityById(studentId);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during find student by Id operation.", exception);
        }
    }

    /**
     * This method delete students by Id in database.
     *
     * @param studentId The student's id.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean deleteStudentById(int studentId) throws ServiceException {
        try{

            StudentDAOImpl studentDAO = new StudentDAOImpl(ConnectionManger.creatConnection());
            return studentDAO.deleteById(studentId);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during delete student by Id operation.", exception);
        }
    }

    /**
     *The method registers student into data base.
     *
     * @param name                The student's name.
     * @param country             The student's country.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean addStudent(String name, String country) throws ServiceException {
        try{

            StudentDAOImpl studentDAO = new StudentDAOImpl(ConnectionManger.creatConnection());
            Student student = new Student();

            student.setName(name);
            student.setCountry(country);

            return studentDAO.insert(student);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during register student operation.", exception);
        }
    }

    /**
     *The method update student information in data base.
     *
     * @param studentIdValue     The student's Id value.
     * @param name                The student's name.
     * @param country             The student's country.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException ServiceException object if execution of method is failed.
     */
    public boolean updateStudent(String studentIdValue, String name, String country) throws ServiceException {
        try{

            StudentDAOImpl studentDAO = new StudentDAOImpl(ConnectionManger.creatConnection());
            Student student = new Student();

            int studentId = Integer.parseInt(studentIdValue);
            student.setId(studentId);
            student.setName(name);
            student.setCountry(country);

            return studentDAO.update(student);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during update student information operation.", exception);
        }
    }
}
