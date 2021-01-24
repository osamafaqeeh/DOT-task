package com.osama.task.entities;


/**
 * This class describes student of application.
 *
 * @author Osama Alfaqeeh
 * @see Entity
 */
public class Student extends Entity {
    private String name;
    private String country;

    /**
     * Instantiates a new student.
     */
    public Student() {
    }

    /**
     * Gets student's name.
     *
     * @return the student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets student's name.
     *
     * @param name the student's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets student's country.
     *
     * @return the student's country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets student's country.
     *
     * @param country the student's country.
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * This method equals two objects.
     *
     * @param object the object.
     * @return true if objects are equal and false otherwise.
     */

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }
        Student student = (Student) object;

        if (name != null ? !name.equals(student.getName()) : student.name != null) {
            return false;
        }
        if (country != null ? !country.equals(student.country) : student.country != null) {
            return false;
        }
        return true;
    }

    /**
     * This method calculate object's hashcode.
     *
     * @return hashcode of object.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);

        return result;
    }

    /**
     * This method builds string information about object.
     *
     * @return string information about object.
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
