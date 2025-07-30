// Handles registration, login, password change.
package service;

import Abstract.User;
import dao.UserDAO;
import exception.InvalidLoginException;




public class UserService {
    private UserDAO userDAO;
        public UserService() {
            this.userDAO = new UserDAO();
        }
//
        public void createUser(String username,String password){
            User user = new User(0, username, password, "student");
            userDAO.save(user);
            System.out.println("User created successfully: " + username);
        }

        public void updateUser(String username, String newPassword){
            User user = userDAO.findByUsername(username);
            if (user != null) {
                user.setPassword(newPassword);
                userDAO.update(user);
                System.out.println("✅ Password updated for user: " + username);
            } else {
                System.out.println("❌ User not found: " + username);

            }

        }

        public User loginString (String username, String password) throws InvalidLoginException {
            User user = userDAO.findByUsername(username);

            if (user == null || !user.getPassword().equals(password)) {
                throw new InvalidLoginException("Invalid username or password.");
            }

            return user;


        }
        }



