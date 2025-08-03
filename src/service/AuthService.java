package service;

import Abstract.User;
import dao.UserDAO;
import exception.InvalidLoginException;

public class AuthService {
    private UserDAO userDAO = new UserDAO();

    public User login(String username, String password) throws InvalidLoginException {
        User user = userDAO.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // ✅ Login successful
        } else {
            throw new InvalidLoginException("Invalid username or password.");
        }
    }
}
