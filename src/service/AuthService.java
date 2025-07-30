// Stores current logged-in user and manages role switching.
package service;

public class AuthService {
    public String login(String username, String password) {
        // Dummy logic for testing
        if (username.equals("admin") && password.equals("admin")) return "admin";
        if (username.equals("student") && password.equals("student")) return "student";
        return null;
    }
}

