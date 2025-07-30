// Shown at start: Login, Register, Exit.
package ui;

import java.util.Scanner;
import service.AuthService;
import util.FileLogger;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthService authService = new AuthService();

    public static void main(String[] args) {
        FileLogger.log("System started.");
        while (true) {
            System.out.println("\n🎓 Welcome to Student Registration System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    handleLogin();
                    break;
                case "2":
                    FileLogger.log("System exited.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }

    private static void handleLogin() {
        System.out.print("👤 Username: ");
        String username = scanner.nextLine();
        System.out.print("🔑 Password: ");
        String password = scanner.nextLine();

        String role = authService.login(username, password);
        if (role == null) {
            System.out.println("❌ Login failed!");
            FileLogger.log("Login failed for user: " + username);
        } else {
            FileLogger.log("Login success for user: " + username);
            if (role.equals("admin")) {
                AdminMenu.show();
            } else {
                StudentMenu.show(username);
            }
        }
    }
}

    
}
