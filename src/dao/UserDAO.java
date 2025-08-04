package dao;

import Abstract.User;
<<<<<<< HEAD



=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;
import model.Student;

public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("username");
                String pwd = rs.getString("password");
                String role = rs.getString("role");

                if ("ADMIN".equalsIgnoreCase(role)) {
                    return new Admin(id, uname, pwd, role);
                } else if ("STUDENT".equalsIgnoreCase(role)) {
                    return new Student(id, uname, pwd, role);
                } else {
                    System.out.println("⚠ Unknown role found in DB: " + role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }

    // Save a new user
    public void save(User user) {
        try {
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
            System.out.println("✅ User saved: " + user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update user
    public void update(User user) {
        try {
            String sql = "UPDATE users SET password = ?, role = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setInt(3, user.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ User updated: " + user.getUsername());
            } else {
                System.out.println("⚠ No user found to update: " + user.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete user
    public void delete(int userId) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            System.out.println("🗑 User deleted: ID " + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> origin/main
