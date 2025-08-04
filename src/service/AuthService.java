package service;

import Abstract.User;
import dao.UserDAO;
import exception.InvalidLoginException;
import java.sql.Connection;
import util.Database;

public class AuthService {
<<<<<<< HEAD
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
=======
    public String login(String username, String password) {
        // Dummy logic for testing
        if (username.equals("admin") && password.equals("admin")) return "admin";
        if (username.equals("student") && password.equals("student")) return "student";
        return null;
>>>>>>> f4fd8323e3e006535a6130b71e69a8ecb64df773
    }
}

