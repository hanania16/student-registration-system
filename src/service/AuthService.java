// Stores current logged-in user and manages role switching.
package service;

import dao.UserDAO;
import model.User;
import exception.InvalidLoginException;
import util.SessionManager;

public class AuthService {
    private UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String username, String password) throws InvalidLoginException {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            SessionManager.setCurrentUser(user);
            return user;
        }
        throw new InvalidLoginException("Invalid username or password");
    }

    public void logout() {
        SessionManager.clear();
    }
}

