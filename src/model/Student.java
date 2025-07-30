// Holds student info and registered courses (List/Set).
package model;

import Abstract.User;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String department;
    private List<Course> registeredCourses;

    public Student(int id, String username, String password, String department) {
        super(id, username, password, "student");
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}



