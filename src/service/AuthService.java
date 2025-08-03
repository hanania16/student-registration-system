package service;

import dao.UserDAO;
import Abstract.User;
import exception.InvalidLoginException;
import interfaces.Authenticatable;
import java.util.Optional;

public class AuthService implements Authenticatable {

    private UserDAO userDAO = new UserDAO();

    @Override
    public User login(String username, String password) throws InvalidLoginException {
        Optional<User> userOpt = userDAO.findByUsername(username, password);

        if (userOpt.isEmpty()) {
            throw new InvalidLoginException("Invalid username or password.");
        }

        return userOpt.get();
    }
}
