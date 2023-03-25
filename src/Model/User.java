package Model;

public class User {
    private int id;
    private String username;
    private String password;
    private int origRole;
    private int role = 2;
    private String salt;
    private String sq1;
    private String sq2;
    private String sq3;
    private String saltSq1;
    private String saltSq2;
    private String saltSq3;
    private int locked = 0;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public User(int id, String username, String password, int origRole, int role, String salt, String sq1, String sq2, String sq3, String saltSq1, String saltSq2, String saltSq3, int locked){
        this.id = id;
        this.username = username;
        this.password = password;
        this.origRole = origRole;
        this.role = role;
        this.salt = salt;
        this.sq1 = sq1;
        this.sq2 = sq2;
        this.sq3 = sq3;
        this.saltSq1 = saltSq1;
        this.saltSq2 = saltSq2;
        this.saltSq3 = saltSq3;
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
    
    public int getorigRole() {
        return origRole;
    }

    public void setorigRole(int origRole) {
        this.origRole = origRole;
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
    
    public String getSq1(){
        return sq1;
    }
    
    public void setSq1(String sq1){
        this.sq1 = sq1;
    }
    
    public String getSq2(){
        return sq2;
    }
    
    public void setSq2(String sq2){
        this.sq2 = sq2;
    }
    
    public String getSq3(){
        return sq3;
    }
    
    public void setSq3(String sq3){
        this.sq3 = sq3;
    }
    
    public String getSaltSq1(){
        return saltSq1;
    }
    
    public void setSaltSq1(String saltSq1){
        this.saltSq1 = saltSq1;
    }
    
    public String getSaltSq2(){
        return saltSq2;
    }
    
    public void setSaltSq2(String saltSq2){
        this.saltSq2 = saltSq2;
    }
    
    public String getSaltSq3(){
        return saltSq3;
    }
    
    public void setSaltSq3(String saltSq3){
        this.saltSq3 = saltSq3;
    }
    
    
}
