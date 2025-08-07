// package service;

// import Abstract.User;
// import dao.UserDAO;
// import exception.InvalidLoginException;
// import java.sql.Connection;
// import util.Database;

// public class AuthService {
//     private UserDAO userDAO;

//     public AuthService() {
//         try {
//             Connection conn = Database.getConnection();
//             this.userDAO = new UserDAO(conn);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public User login(String username, String password) throws InvalidLoginException {
//         User user = userDAO.findByUsername(username);

//         if (user == null) {
//             throw new InvalidLoginException("User not found.");
//         }

//         // In a real app, hash password check
//         if (!user.getPassword().equals(password)) {
//             throw new InvalidLoginException("Invalid password.");
//         }

//         return user;
//     }
// }

package service;

import Abstract.User;
import dao.UserDAO;
import exception.InvalidLoginException;
import interfaces.Authenticatable;
import java.sql.Connection;
import util.Database;

public class AuthService implements Authenticatable {
    private UserDAO userDAO;

    public AuthService() {
        try {
            Connection conn = Database.getConnection();
            this.userDAO = new UserDAO(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(String username, String password) throws InvalidLoginException {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            throw new InvalidLoginException("User not found.");
        }

        if (!user.getPassword().equals(password)) {
            throw new InvalidLoginException("Invalid password.");
        }

        return user;
    }
}

