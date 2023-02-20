package Model;

public class User {
    private int id;
    private String username;
    private String password;
    private int role = 2;
    private String salt;
    private int locked = 0;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public User(int id, String username, String password, int role, String salt, int locked){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.salt = salt;
        this.locked = locked;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public String getSalt(){
        return salt;
    }
    
    public void setSalt(String salt){
        this.salt = salt;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
