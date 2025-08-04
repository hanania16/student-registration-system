package dao;

<<<<<<< HEAD
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import util.Database;

public class CourseDAO {

    // Find course by ID
    public Course findById(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                       rs.getString("course_name"),
                        rs.getInt("max_capacity"),
                        rs.getInt("department_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Add a new course
    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (course_name, max_capacity, department_id) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getMaxCapacity());
            stmt.setInt(3, course.getDepartmentId());

            stmt.executeUpdate();
            System.out.println("✅ Course added to DB successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all courses
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getInt("max_capacity"),
                        rs.getInt("department_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    // Delete a course
    public boolean deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0; // true if a course was deleted
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
=======
import model.Course;
import java.util.HashMap;
import java.util.Map;

public class CourseDAO {
    private static Map<String, Course> courseMap = new HashMap<>();

    public boolean save(Course course) {
        if (courseMap.containsKey(course.getCourseId())) {
            return false; // already exists
        }
        courseMap.put(course.getCourseId(), course);
        return true;
>>>>>>> f4fd8323e3e006535a6130b71e69a8ecb64df773
    }
}
