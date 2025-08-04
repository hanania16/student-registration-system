
package service;

import dao.CourseDAO;
import model.Course;
import exceptions.CourseFullException;
import interfaces.Registrable;

import java.util.List;

public class RegistrationService implements Registrable {
    private CourseDAO courseDAO;

    public RegistrationService() {
        this.courseDAO = new CourseDAO(); // Could also inject this
    }

    @Override
    public boolean register(int studentId, int courseId) {
        Course course = null;

        // Load all courses to find the one
        List<Course> courses = courseDAO.getAllCourses();
        for (Course c : courses) {
            if (c.getId() == courseId) {
                course = c;
                break;
            }
        }

        if (course == null) {
            System.out.println("❌ Course not found.");
            return false;
        }

        if (course.isFull()) {
            throw new CourseFullException("Course is full. Try another course.");
        }

        return courseDAO.registerStudent(studentId, courseId);
    }

    @Override
    public boolean drop(int studentId, int courseId) {
        return courseDAO.dropStudent(studentId, courseId);
    }

    public List<Course> viewRegisteredCourses(int studentId) {
        return courseDAO.getRegisteredCourses(studentId);
    }
}
