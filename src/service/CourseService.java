// Admin features: add/remove course.
package service;

import dao.CourseDAO;
import model.Course;

public class CourseService {
    private CourseDAO courseDAO = new CourseDAO();

    public void createCourse(String courseId, String courseName) {
        Course course = new Course(courseId, courseName);
        boolean success = courseDAO.save(course);

        if (success) {
            System.out.println("✅ Course added: " + courseId + " - " + courseName);
        } else {
            System.out.println("❌ Failed to add course. It may already exist.");
        }
    }
}



