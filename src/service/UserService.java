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
            // Call DAO save method to store the user in the database
            userDAO.save(user);
            System.out.println("User created successfully: " + username);
        }

        public void updateUser(String username, String newPassword){
            User user = userDAO.findByUsername(username);
            // Step 2: Check if user exists
            if (user != null) {
                // Step 3: Update the password
                user.setPassword(newPassword);

                // Step 4: Save updated user
                userDAO.update(user);

                System.out.println("✅ Password updated for user: " + username);
            } else {
                System.out.println("❌ User not found: " + username);
                // You could throw a custom exception here if needed
            }

        }

        public User loginString (String username, String password) throws InvalidLoginException {
            // Find the user by username using DAO
            User user = userDAO.findByUsername(username);

            // Check if user exists and password matches
            if (user == null || !user.getPassword().equals(password)) {
                throw new InvalidLoginException("Invalid username or password.");
            }

            // Successful login, return the user
            return user;


        }
        }



