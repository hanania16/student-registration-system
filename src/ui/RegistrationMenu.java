package ui;

import Abstract.User;
import service.RegistrationService;
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

    private void studentMenu(Scanner sc) {
        // show student options: view courses, register, drop
    }

    private void adminMenu(Scanner sc) {
        // show admin options: add/remove courses, view all registrations
    }
}
