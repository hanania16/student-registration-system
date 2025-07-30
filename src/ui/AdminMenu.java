// 	Admin adds/removes courses, views all students.
package ui;

import java.util.Scanner;
import service.UserService;

public class AdminMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();

    public static void show() {
        while (true) {
            System.out.println("\n🧑‍💼 Admin Menu");
            System.out.println("1. Add new course");
            System.out.println("2. Create new user");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Course ID: ");
                    String id = scanner.nextLine();
                    userService.createCourse(name, id);
                    break;
                case "2":
                    System.out.print("New Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Role (admin/student): ");
                    String role = scanner.nextLine();
                    userService.createUser(username, password, role);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}
