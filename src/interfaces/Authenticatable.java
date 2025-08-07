package interfaces;

import Abstract.User;
import exception.InvalidLoginException;

public interface Authenticatable {
    User login(String username, String password) throws InvalidLoginException;
}
