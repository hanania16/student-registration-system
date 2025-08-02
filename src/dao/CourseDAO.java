package dao;

import model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private Connection conn;

    public CourseDAO(Connection conn) {
        this.conn = conn;
    }

    public Course findById(int id) {
        try {
            String sql = "SELECT * FROM courses WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getInt("max_capacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCourse(Course course) {
        try {
            String sql = "INSERT INTO courses (course_name, max_capacity) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getMaxCapacity());
            stmt.executeUpdate();
            System.out.println("Course added to DB successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // You can add update, delete, getAll methods similarly
}
