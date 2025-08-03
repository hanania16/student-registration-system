package service;

import Abstract.User;
import dao.UserDAO;
import exception.InvalidLoginException;
import interfaces.Authenticatable;

import java.util.Optional;

public class AuthService implements Authenticatable {

    private UserDAO userDAO = new UserDAO();

    @Override
    public User login(String username, String password) throws InvalidLoginException {
        Optional<User> userOpt = userDAO.findByUsernameAndPassword(username, password);

        if (userOpt.isEmpty()) {
            throw new InvalidLoginException("Invalid username or password.");
        }

        return userOpt.get();
    }
}
