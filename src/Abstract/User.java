package Abstract;

<<<<<<< HEAD
public abstract class User {
    protected  int id;
    protected  String username;
    protected  String password;
    protected  String role;
=======

public abstract class User {
    protected int id;
    protected String username;
    protected String password;
    protected String role;
>>>>>>> origin/main

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
<<<<<<< HEAD
    // Getters and Setters
=======

    // Getters
>>>>>>> origin/main
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

<<<<<<< HEAD
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Abstract method to force subclasses to provide role-specific menu
    public abstract void displayinfo();
=======
    // Setters
    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }

    // Every subclass MUST define its own menu
    public abstract void showMenu();
>>>>>>> origin/main
}
