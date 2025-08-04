import Abstract.User;
import exception.InvalidLoginException;
import java.util.Scanner;
import service.AuthService;
import ui.RegistrationMenu;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService authService = new AuthService();

        System.out.println("=== Student Registration System ===");

        try {
            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            User loggedInUser = authService.login(username, password);
            System.out.println("\n✅ Login successful. Welcome, " + loggedInUser.getUsername() + "!");

            RegistrationMenu regMenu = new RegistrationMenu(loggedInUser);
            regMenu.showMenu();

        } catch (InvalidLoginException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
