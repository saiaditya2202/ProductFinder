import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String role;
    private String store;

    public User(String username, String password, String role, String store) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.store = store;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getStore() { return store; }
}
