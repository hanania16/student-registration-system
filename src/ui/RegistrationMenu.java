package ui;

import Abstract.User;
import dao.CourseDAO;
import dao.StudentDAO;
import exception.CourseFullException;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Student;
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
<<<<<<< HEAD
                case "1":
                    viewAvailableCourses();
                    break;
                case "2":
                    System.out.print("Enter Course ID to register: ");
                    try {
                    int courseIdReg = Integer.parseInt(sc.nextLine());
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
                    try {
                    int courseIdDrop = Integer.parseInt(sc.nextLine());
                    if (regService.drop(currentUser.getId(), courseIdDrop)) {
                        System.out.println("✅ Course dropped.");
                    } else {
                        System.out.println("⚠ Could not drop course.");
                    }
                    } catch (NumberFormatException e){
                        System.out.println("❌ Invalid course ID.");
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
=======
                case 1 -> showAllCourses();
                case 2 -> showStudentCourses();
                case 3 -> registerForCourse(sc);
                case 4 -> dropCourse(sc);
                case 5 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
>>>>>>> 5f23f718a4a3710fa7c264d4a356023885da86fc
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
            System.out.println("3. Add Students");
            System.out.println("4. Delete Course");
            System.out.println("5. Delete Student");
            System.out.println("6. View All Students");
            System.out.println("7. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showAllCourses();
                case 2 -> addCourse(sc);
                case 3 -> addStudent(sc);
                case 4 -> deleteCourse(sc);
                case 5 -> {
                        System.out.print("Enter Student ID to delete: ");
                        int id = sc.nextInt();
                        deleteStudent(id);
                        System.out.println("Student with id " + id + " deleted successfully");
                }
                case 6 -> showAllStudents();
                case 7 -> System.out.println("Logging out...");
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

private void addStudent(Scanner sc) {
    sc.nextLine(); // clear buffer
    System.out.print("Student username: ");
    String username = sc.nextLine();
    System.out.print("Password: ");
    String password = sc.nextLine();
    System.out.print("Role: ");
    String role = sc.nextLine();
    System.out.print("Department ID: ");
    int deptId = sc.nextInt();

    var newStudent = new Student(0, username, password, role, deptId);
    StudentDAO studentDAO = new StudentDAO(); // create instance
    studentDAO.addStudent(newStudent); // call instance method
}
private void deleteStudent(int id) {
    StudentDAO studentDAO = new StudentDAO();
    if (studentDAO.deleteStudent(id)) {
        System.out.println("✅ Student deleted successfully.");
    } else {
        System.out.println("❌ No student found with ID " + id);
    }
}

private void showAllStudents() {
    StudentDAO studentDAO = new StudentDAO();
    var students = studentDAO.getAllStudents();

    if (students.isEmpty()) {
        System.out.println("No students found.");
        return;
    }

    System.out.println("\n--- Registered Students ---");
    for (Student s : students) {
        System.out.printf("ID: %d | Username: %s | Role: %s\n",
                s.getId(), s.getUsername(), s.getRole());
    }
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
