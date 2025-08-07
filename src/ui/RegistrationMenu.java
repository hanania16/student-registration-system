// Source code is decompiled from a .class file using FernFlower decompiler.
package ui;

import Abstract.User;
import dao.CourseDAO;
import dao.StudentDAO;
import exception.CourseFullException;
import java.util.Iterator;
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

   }

   private void studentMenu(Scanner var1) {
      int var2;
      do {
         System.out.println("\n=== Student Menu ===");
         System.out.println("1. View Available Courses");
         System.out.println("2. View My Courses");
         System.out.println("3. Register for a Course");
         System.out.println("4. Drop a Course");
         System.out.println("5. Logout");
         System.out.print("Choose: ");
         var2 = var1.nextInt();
         switch (var2) {
            case 1:
               this.showAllCourses();
               break;
            case 2:
               this.showStudentCourses();
               break;
            case 3:
               this.registerForCourse(var1);
               break;
            case 4:
               this.dropCourse(var1);
               break;
            case 5:
               System.out.println("Logging out...");
               break;
            default:
               System.out.println("Invalid choice.");
         }
      } while(var2 != 5);

            switch (choice) {
                case 1 -> showAllCourses();
                case 2 -> showStudentCourses();
                case 3 -> registerForCourse(sc);
                case 4 -> dropCourse(sc);
                case 5 -> {System.out.println("Logging out...");
                            return; // exit studentMenu method → goes back to Main
                         }

                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

   private void adminMenu(Scanner var1) {
      int var2;
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
         var2 = var1.nextInt();
         switch (var2) {
            case 1:
               this.showAllCourses();
               break;
            case 2:
               this.addCourse(var1);
               break;
            case 3:
               this.addStudent(var1);
               break;
            case 4:
               this.deleteCourse(var1);
               break;
            case 5:
               System.out.print("Enter Student ID to delete: ");
               int var3 = var1.nextInt();
               this.deleteStudent(var3);
               System.out.println("Student with id " + var3 + " deleted successfully");
               break;
            case 6:
               this.showAllStudents();
               break;
            case 7:
               System.out.println("Logging out...");
               break;
            default:
               System.out.println("Invalid choice.");
         }
      } while(var2 != 4);

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
                case 7 -> { System.out.println("Logging out...");
                                return; // exit adminMenu method → goes back to Main
                          }

                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }

   private void showAllCourses() {
      List var1 = this.regService.getAllCourses();
      if (var1.isEmpty()) {
         System.out.println("No courses found.");
      } else {
         System.out.println("\n--- Available Courses ---");
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            Course var3 = (Course)var2.next();
            System.out.printf("[%d] %s | Capacity: %d | Enrolled: %d\n", var3.getId(), var3.getCourseName(), var3.getMaxCapacity(), var3.getEnrolledStudentsCount());
         }

    // ====================== REGISTER FOR A COURSE ======================
    private void registerForCourse(Scanner sc) {
        // Show all available courses first
        showAllCourses();
        System.out.print("Enter Course ID to register: ");
        int courseId = sc.nextInt();
        try {
            regService.registerStudentToCourse(currentUser.getId(), courseId);
        } catch (CourseFullException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }


    // ====================== ADD COURSE (ADMIN) ======================
    private void addCourse(Scanner sc) {
        System.out.print("Course Name: ");
        sc.nextLine(); // clear buffer
        String name = sc.nextLine();
        System.out.print("Max Capacity: ");
        int capacity = sc.nextInt();
         System.out.print(
    "Departments: \n" +
    "id |          name\n" +
    "----+------------------------\n" +
    "1  | Computer Science\n" +
    "2  | Information Technology\n" +
    "3  | Electrical Engineering\n" +
    "Enter department ID: "
);
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
    System.out.print(
    "Departments: \n" +
    "id |          name\n" +
    "----+------------------------\n" +
    "1  | Computer Science\n" +
    "2  | Information Technology\n" +
    "3  | Electrical Engineering\n" +
    "Enter department ID: "
);

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
       System.out.println("\n--- My Courses ---");
       Iterator var2 = var1.iterator();

       while(var2.hasNext()) {
          Course var3 = (Course)var2.next();
          System.out.printf("[%d] %s\n", var3.getId(), var3.getCourseName());
       }

    }
 }

 private void registerForCourse(Scanner var1) {
    System.out.print("Enter Course ID to register: ");
    int var2 = var1.nextInt();

    try {
       this.regService.registerStudentToCourse(this.currentUser.getId(), var2);
    } catch (CourseFullException var4) {
       System.out.println("❌ " + var4.getMessage());
    }

 }

    // ====================== DELETE COURSE (ADMIN) ======================
    private void deleteCourse(Scanner sc) {
        showAllCourses();
        System.out.print("Enter Course ID to delete: ");
        int courseId = sc.nextInt();
        if (courseDAO.deleteCourse(courseId)) {
            System.out.println("✅ Course deleted.");
        } else {
            System.out.println("❌ Could not delete course (ID not found).");
        }
    }

 }

 private void showAllStudents() {
    StudentDAO var1 = new StudentDAO();
    List var2 = var1.getAllStudents();
    if (var2.isEmpty()) {
       System.out.println("No students found.");
    } else {
       System.out.println("\n--- Registered Students ---");
       Iterator var3 = var2.iterator();

       while(var3.hasNext()) {
          Student var4 = (Student)var3.next();
          System.out.printf("ID: %d | Username: %s | Role: %s\n", var4.getId(), var4.getUsername(), var4.getRole());
       }

    }
 }

 private void deleteCourse(Scanner var1) {
    System.out.print("Enter Course ID to delete: ");
    int var2 = var1.nextInt();
    if (this.courseDAO.deleteCourse(var2)) {
       System.out.println("✅ Course deleted.");
    } else {
       System.out.println("❌ Could not delete course (ID not found).");
    }

 }
