package ui;

import Abstract.User;
import dao.CourseDAO;
import exception.CourseFullException;
import java.util.List;
import java.util.Scanner;
import model.Course;
import service.RegistrationService;

public class RegistrationMenu {
    private User currentUser;
    private RegistrationService regService = new RegistrationService();
    private CourseDAO courseDAO = new CourseDAO();

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

    // ====================== STUDENT MENU ======================
    private void studentMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. View Available Courses");
            System.out.println("2. View My Courses");
            System.out.println("3. Register for a Course");
            System.out.println("4. Drop a Course");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showAllCourses();
                case 2 -> showStudentCourses();
                case 3 -> registerForCourse(sc);
                case 4 -> dropCourse(sc);
                case 5 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    // ====================== ADMIN MENU ======================
    private void adminMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. View All Courses");
            System.out.println("2. Add Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showAllCourses();
                case 2 -> addCourse(sc);
                case 3 -> deleteCourse(sc);
                case 4 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    // ====================== VIEW ALL COURSES ======================
    private void showAllCourses() {
        List<Course> courses = regService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("\n--- Available Courses ---");
        for (Course c : courses) {
            System.out.printf("[%d] %s | Capacity: %d | Enrolled: %d\n",
                    c.getId(), c.getCourseName(), c.getMaxCapacity(), c.getEnrolledStudentsCount());
        }
    }

    // ====================== VIEW STUDENT COURSES ======================
    private void showStudentCourses() {
        List<Course> myCourses = regService.getStudentCourses(currentUser.getId());
        if (myCourses.isEmpty()) {
            System.out.println("You are not registered for any courses.");
            return;
        }
        System.out.println("\n--- My Courses ---");
        for (Course c : myCourses) {
            System.out.printf("[%d] %s\n", c.getId(), c.getCourseName());
        }
    }

    // ====================== REGISTER FOR A COURSE ======================
    private void registerForCourse(Scanner sc) {
        System.out.print("Enter Course ID to register: ");
        int courseId = sc.nextInt();
        try {
            regService.registerStudentToCourse(currentUser.getId(), courseId);
        } catch (CourseFullException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // ====================== DROP A COURSE ======================
    private void dropCourse(Scanner sc) {
        System.out.print("Enter Course ID to drop: ");
        int courseId = sc.nextInt();
        regService.dropCourse(currentUser.getId(), courseId);
    }

    // ====================== ADD COURSE (ADMIN) ======================
    private void addCourse(Scanner sc) {
        System.out.print("Course Name: ");
        sc.nextLine(); // clear buffer
        String name = sc.nextLine();
        System.out.print("Max Capacity: ");
        int capacity = sc.nextInt();
        System.out.print("Department ID: ");
        int deptId = sc.nextInt();

        Course newCourse = new Course(0, name, capacity, deptId);
        courseDAO.addCourse(newCourse);
    }

    // ====================== DELETE COURSE (ADMIN) ======================
    private void deleteCourse(Scanner sc) {
        System.out.print("Enter Course ID to delete: ");
        int courseId = sc.nextInt();
        if (courseDAO.deleteCourse(courseId)) {
            System.out.println("✅ Course deleted.");
        } else {
            System.out.println("❌ Could not delete course (ID not found).");
        }
    }
}
