package dao;

import Abstract.User;

import java.sql.*;

public class UserDAO {
    private Database db;

    public UserDAO(Database db) {
        this.db = db;
    }

    public void save(User user) {
        try (Connection conn = db.getConnection()) {
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
            System.out.println("User saved to DB: " + user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findByUsername(String username) {
        try (Connection conn = db.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        try (Connection conn = db.getConnection()) {
            String sql = "UPDATE users SET password = ?, role = ? WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getUsername());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User updated in DB: " + user.getUsername());
            } else {
                System.out.println("User not found for update: " + user.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
