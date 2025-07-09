// For login, register user, get user by email.
package dao;

import Abstract.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users = new ArrayList<>(); // Mock database




    public void save(User user) {
        users.add(user);
        System.out.println("User saved: " + user.getUsername());
    }

    public User findByUsername(String username) {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            // u is actually Student or Admin, a concrete class

            }
        }
        return null; // if no user found with that username
    }
    public void update(User user) {
        // For in-memory list, the object is already updated
        System.out.println("User updated: " + user.getUsername());
    }

}




