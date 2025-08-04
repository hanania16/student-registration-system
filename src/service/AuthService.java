package service;

import Abstract.User;
import dao.UserDAO;
import exception.InvalidLoginException;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        try {
            Connection conn = Database.getConnection();
            this.userDAO = new UserDAO(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String username, String password) throws InvalidLoginException {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new InvalidLoginException("User not found.");
        }

        // In a real app, hash password check
        if (!user.getPassword().equals(password)) {
            throw new InvalidLoginException("Invalid password.");
        }

        return user;
    }

    public User findByUsername(String username) {
    try {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String role = rs.getString("role");

            if ("ADMIN".equalsIgnoreCase(role)) {
                return new Admin(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    role
                );
            } else {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    role
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
