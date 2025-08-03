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
            String choi
