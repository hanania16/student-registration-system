// Shown at start: Login, Register, Exit.
package ui;

import java.util.Scanner;

import Abstract.User;
import exception.InvalidLoginException;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    try {
        User user = authService.login(username, password);
        System.out.println("Welcome, " + user.getFullName() + "!");
        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            AdminMenu.show();
        } else {
            StudentMenu.show();
        }
    } catch (InvalidLoginException e) {
        System.out.println(e.getMessage());
    }

}
