// 	Course registration logic: add/drop, validation.
package service;

import dao.CourseDAO;
import model.Course;
import exception.CourseFullException;
import interfaces.Registrable;

import java.util.List;

public class RegistrationService implements Registrable {
    private CourseDAO courseDAO = new CourseDAO();

    @Override
    public boolean register(int studentId, int courseId) throws CourseFullException {
        List<Course> courses = courseDAO.getAllCourses();
        
        // Check if course is full before registration
        for (Course c : courses) {
            if (c.getId() == courseId) {
                if (c.isFull()) {
                    throw new CourseFullException("Course is full. Cannot register.");
                }
            }
        }
        return courseDAO.registerStudent(studentId, courseId);
    }

    @Override
    public boolean drop(int studentId, int courseId) {
        return courseDAO.dropStudent(studentId, courseId);
    }

    // Additional helper methods
    public List<Course> viewAvailableCourses() {
        return courseDAO.getAllCourses();
    }

    public List<Course> viewStudentCourses(int studentId) {
        return courseDAO.getRegisteredCourses(studentId);
    }
}
