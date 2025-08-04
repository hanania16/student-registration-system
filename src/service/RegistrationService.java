package service;

import dao.CourseDAO;
import model.Course;
import util.Database;
import exception.CourseFullException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private CourseDAO courseDAO = new CourseDAO();

    // Get all courses
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    // Register a student to a course
    public void registerStudentToCourse(int studentId, int courseId) throws CourseFullException {
        try (Connection conn = Database.getConnection()) {
            // Check if already registered
            String checkSql = "SELECT * FROM registrations WHERE student_id = ? AND course_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, studentId);
                checkStmt.setInt(2, courseId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("⚠ You are already registered for this course.");
                    return;
                }
            }

            // Get course details
            Course course = courseDAO.findById(courseId);
            if (course == null) {
                System.out.println("❌ Course not found.");
                return;
            }

            // Check capacity
            if (course.getEnrolledStudentsCount() >= course.getMaxCapacity()) {
                throw new CourseFullException("Course is already full!");
            }

            // Register student
            String sql = "INSERT INTO registrations (student_id, course_id) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, studentId);
                stmt.setInt(2, courseId);
                stmt.executeUpdate();
            }

            // Update enrolled_count in courses table
            String updateSql = "UPDATE courses SET enrolled_count = enrolled_count + 1 WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
                stmt.setInt(1, courseId);
                stmt.executeUpdate();
            }

            System.out.println("✅ Successfully registered to course: " + course.getCourseName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Drop a course
    public void dropCourse(int studentId, int courseId) {
        try (Connection conn = Database.getConnection()) {
            // Remove from registrations
            String sql = "DELETE FROM registrations WHERE student_id = ? AND course_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, studentId);
                stmt.setInt(2, courseId);
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    // Reduce enrolled count
                    String updateSql = "UPDATE courses SET enrolled_count = enrolled_count - 1 WHERE id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, courseId);
                        updateStmt.executeUpdate();
                    }
                    System.out.println("✅ Dropped from course successfully.");
                } else {
                    System.out.println("⚠ You are not registered in this course.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View student's registered courses
    public List<Course> getStudentCourses(int studentId) {
        List<Course> courses = new ArrayList<>();
        String sql = """
            SELECT c.* FROM courses c
            JOIN registrations r ON c.id = r.course_id
            WHERE r.student_id = ?
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity"),
                        rs.getInt("department_id"),
                        rs.getInt("enrolled_count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
