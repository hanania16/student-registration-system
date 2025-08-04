// After student logs in: Register, Drop, View Courses.
package ui;

import java.util.Scanner;
import service.RegistrationService;

public class StudentMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static RegistrationService regService = new RegistrationService();

    public static void show(String username) {
        while (true) {
            System.out.println("\n👩🎓 Student Menu");
            System.out.println("1. Register for course");
            System.out.println("2. Drop course");
            System.out.println("3. View registered courses");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    regService.registerCourse(username, courseId);
                    break;
                case "2":
                    System.out.print("Enter Course ID to drop: ");
                    String courseDrop = scanner.nextLine();
                    regService.dropCourse(username, courseDrop);
                    break;
                case "3":
                    regService.viewRegisteredCourses(username);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}
