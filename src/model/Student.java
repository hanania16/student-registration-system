<<<<<<< HEAD
package model;

import Abstract.User;

public class Student extends User {
    private int departmentId;
    public Student(int id, String username, String password, String role) {
        super(id, username, password, role);
    }

    public Student(int id, String username, String password, String role, int departmentId) {
        super(id, username, password, role);
        this.departmentId = departmentId;
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Student Menu ===");
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for a Course");
        System.out.println("3. Drop a Course");
        System.out.println("0. Logout");
    }
}
=======
>>>>>>> f4fd8323e3e006535a6130b71e69a8ecb64df773
