package dao;

import Abstract.User;
import model.Admin;
import model.Student;
import util.ConfigReader;

import java.sql.*;
import java.util.Optional;

public class UserDAO {

    /**
     * Finds a user by username and password for authentication.
     */
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        Optional<User> userOpt = Optional.empty();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(
                ConfigReader.getDbUrl(),
                ConfigReader.getDbUsername(),
                ConfigReader.getDbPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");

                if (role.equalsIgnoreCase("admin")) {
                    userOpt = Optional.of(new Admin(id, username, password));
                } else {
                    userOpt = Optional.of(new Student(id, username, password));
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }

        return userOpt;
    }

    /**
     * Save a new user to the database.
     */
    public void save(User user) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(
                ConfigReader.getDbUrl(),
                ConfigReader.getDbUsername(),
                ConfigReader.getDbPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();

            System.out.println("✅ User saved: " + user.getUsername());

        } catch (SQLException e) {
            System.out.println("❌ Failed to save user: " + e.getMessage());
        }
    }

    /**
     * Update an existing user's password or role.
     */
    public void update(User user) {
        String sql = "UPDATE users SET password = ?, role = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(
                ConfigReader.getDbUrl(),
                ConfigReader.getDbUsername(),
                ConfigReader.getDbPassword());
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setInt(3, user.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ User updated: " + user.getUsername());
            } else {
                System.out.println("⚠ User not found for update: " + user.getUsername());
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to update user: " + e.getMessage());
        }
    }
}
