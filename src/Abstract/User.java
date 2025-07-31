/*Abstract class with shared fields: id, 
 name, email, password. Both Student 
and Admin extend this.*/
package Abstract;

public class User {
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
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    // Set password
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
