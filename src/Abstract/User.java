/*Abstract class with shared fields: id, 
 name, email, password. Both Student 
and Admin extend this.*/
package Abstract;

public abstract class User {
    protected  int id;
    protected  String username;
    protected  String password;
    protected  String role;

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Abstract method to force subclasses to provide role-specific menu
    public abstract void displayinfo();
}
