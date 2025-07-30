// Methods to validate menu input, emails, passwords, etc.
package util;

public class InputValidator {
    public static boolean isValidUsername(String username) {
        return username != null && username.matches("[a-zA-Z0-9_]{3,15}");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}

    
}
