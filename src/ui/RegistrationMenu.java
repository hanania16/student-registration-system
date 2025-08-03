package ui;

import Abstract.User;
import exception.CourseFullException;
import model.Course;
import service.RegistrationService;

import java.util.List;
import java.util.Scanner;

public class RegistrationMenu {
    private User currentUser;
    private RegistrationService regService = new RegistrationService();

    public RegistrationMenu(User user) {
        this.currentUser = user;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        if (currentUser.getRole().equalsIgnoreCase("student")) {
            studentMenu(sc);
        } else if (currentUser.getRole().equalsIgnoreCase("admin")) {
            adminMenu(sc);
        }
    }

    /** ===================== STUDENT MENU ===================== */
    private void studentMenu(Scanner sc) {
        while (true) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View My Courses");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    viewAvailableCourses();
                    break;
                case "2":
                    System.out.print("Enter Course ID to register: ");
                    int courseIdReg = Integer.parseInt(sc.nextLine());
                    try {
                        if (regService.register(currentUser.getId(), courseIdReg)) {
                            System.out.println("✅ Registration successful!");
                        } else {
                            System.out.println("⚠ Could not register. Try again.");
                        }
                    } catch (CourseFullException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Enter Course ID to drop: ");
                    int courseIdDrop = Integer.parseInt(sc.nextLine());
                    if (regService.drop(currentUser.getId(), courseIdDrop)) {
                        System.out.println("✅ Course dropped.");
                    } else {
                        System.out.println("⚠ Could not drop course.");
                    }
                    break;
                case "4":
                    viewMyCourses();
                    break;
                case "0":
                    System.out.println("👋 Logging out...");
                    return;
                default:
                    System.out.println("⚠ Invalid choice.");
            }
        }
    }

    /** ===================== ADMIN MENU ===================== */
    private void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. View All Courses");
            System.out.println("2. Add a Course");
            System.out.println("3. Remove a Course");
            System.out.println("4. View All Student Registrations");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    viewAvailableCourses();
                    break;
                case "2":
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = Integer.parseInt(sc.nextLine());
                    if (regService.addCourse(name, capacity)) {
                        System.out.println("✅ Course added.");
                    } else {
                        System.out.println("⚠ Failed to add course.");
                    }
                    break;
                case "3":
                    System.out.print("Enter Course ID to remove: ");
                    int idRemove = Integer.parseInt(sc.nextLine());
                    if (regService.removeCourse(idRemove)) {
                        System.out.println("✅ Course removed.");
                    } else {
                        System.out.println("⚠ Failed to remove course.");
                    }
                    break;
                case "4":
                    regService.viewAllRegistrations();
                    break;
                case "0":
                    System.out.println("👋 Logging out...");
                    return;
                default:
                    System.out.println("⚠ Invalid choice.");
            }
        }
    }

    /** ===================== HELPER METHODS ===================== */
    private void viewAvailableCourses() {
        List<Course> courses = regService.viewAvailableCourses();
        System.out.println("\n--- Available Courses ---");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    private void viewMyCourses() {
        List<Course> myCourses = regService.viewStudentCourses(currentUser.getId());
        System.out.println("\n--- My Courses ---");
        for (Course c : myCourses) {
            System.out.println(c);
        }
    }
}
