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

   public RegistrationMenu(User var1) {
      this.currentUser = var1;
   }

   public void showMenu() {
      Scanner var1 = new Scanner(System.in);
      if (this.currentUser.getRole().equalsIgnoreCase("student")) {
         this.studentMenu(var1);
      } else if (this.currentUser.getRole().equalsIgnoreCase("admin")) {
         this.adminMenu(var1);
      }

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

      }
   }


private void showStudentCourses() {
    List var1 = this.regService.getStudentCourses(this.currentUser.getId());
    if (var1.isEmpty()) {
       System.out.println("You are not registered for any courses.");
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

 private void dropCourse(Scanner var1) {
    System.out.print("Enter Course ID to drop: ");
    int var2 = var1.nextInt();
    this.regService.dropCourse(this.currentUser.getId(), var2);
 }

 private void addCourse(Scanner var1) {
    System.out.print("Course Name: ");
    var1.nextLine();
    String var2 = var1.nextLine();
    System.out.print("Max Capacity: ");
    int var3 = var1.nextInt();
    System.out.print("Department ID: ");
    int var4 = var1.nextInt();
    Course var5 = new Course(0, var2, var3, var4);
    this.courseDAO.addCourse(var5);
 }

 private void addStudent(Scanner var1) {
    var1.nextLine();
    System.out.print("Student username: ");
    String var2 = var1.nextLine();
    System.out.print("Password: ");
    String var3 = var1.nextLine();
    System.out.print("Role: ");
    String var4 = var1.nextLine();
    System.out.print("Department ID: ");
    int var5 = var1.nextInt();
    Student var6 = new Student(0, var2, var3, var4, var5);
    StudentDAO var7 = new StudentDAO();
    var7.addStudent(var6);
 }

 private void deleteStudent(int var1) {
    StudentDAO var2 = new StudentDAO();
    if (var2.deleteStudent(var1)) {
       System.out.println("✅ Student deleted successfully.");
    } else {
       System.out.println("❌ No student found with ID " + var1);
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
