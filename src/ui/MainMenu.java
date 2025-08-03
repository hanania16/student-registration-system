package ui;

import service.AuthService;
import Abstract.User;
import exception.InvalidLoginException;
import java.util.Scanner;

public class MainMenu {

    private AuthService authService = new AuthService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
        User currentUser = null;

        while (!loggedIn) {
            System.out.println("=== LOGIN ===");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            try {
                currentUser = authService.login(username, password);
                loggedIn = true;
                System.out.println("✅ Login successful as " + currentUser.getRole());
            } catch (InvalidLoginException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        // Redirect based on role
        RegistrationMenu regMenu = new RegistrationMenu(currentUser);
        regMenu.showMenu();
    }
}
