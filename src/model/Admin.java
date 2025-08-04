package model;

import Abstract.User;

public class Admin extends User {
    public Admin(int id, String username, String password, String role) {
        super(id, username, password, role);
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Add Course");
        System.out.println("2. Remove Course");
        System.out.println("3. View All Students & Registrations");
        System.out.println("0. Logout");
    }
}
