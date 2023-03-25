package Controller;

import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLite {
    
    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Database database.db created.");
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createHistoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS history (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " event TEXT NOT NULL,\n"
            + " username TEXT NOT NULL,\n"
            + " desc TEXT NOT NULL,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL UNIQUE,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " price REAL DEFAULT 0.00\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " password TEXT NOT NULL,\n"
            + " origRole INTEGER DEFAULT 2, \n"
            + " role INTEGER DEFAULT 2,\n"
            + " salt TEXT NOT NULL, \n"
            + " SQ1 TEXT NOT NULL, \n"
            + " SQ2 TEXT NOT NULL, \n"
            + " SQ3 TEXT NOT NULL, \n"
            + " saltSq1 TEXT NOT NULL, \n"
            + " saltSq2 TEXT NOT NULL, \n"
            + " saltSq3 TEXT NOT NULL, \n"
            + " locked INTEGER DEFAULT 0\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropHistoryTable() {
        String sql = "DROP TABLE IF EXISTS history;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropLogsTable() {
        String sql = "DROP TABLE IF EXISTS logs;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS product;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void addHistory(String username, String name, int stock, String timestamp) {
        //String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES('" + username + "','" + name + "','" + stock + "','" + timestamp + "')";
        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES(?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setInt(3, stock);
            pstmt.setString(4, timestamp);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void addLogs(String event, String username, String desc, String timestamp) {
        //String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + event + "','" + username + "','" + desc + "','" + timestamp + "')";
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event);
            pstmt.setString(2, username);
            pstmt.setString(3, desc);
            pstmt.setString(4, timestamp);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void addProduct(String name, int stock, double price) {
        //String sql = "INSERT INTO product(name,stock,price) VALUES('" + name + "','" + stock + "','" + price + "')";
        String sql = "INSERT INTO product(name,stock,price) VALUES(?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void addUser(String username, String password, String salt, String sq1, String sq2, String sq3, String saltsq1, String saltsq2, String saltsq3) {
        //String sql = "INSERT INTO users(username,password,salt,sq1,sq2,sq3,saltsq1,saltsq2,saltsq3) VALUES('" + username + "','" + password + "','" + salt + "','" + sq1 + "','"  + sq2 + "','" + sq3 + "','" + saltsq1 + "','" + saltsq2 + "','" + saltsq3 + "')";
        String sql = "INSERT INTO users(username,password,salt,sq1,sq2,sq3,saltsq1,saltsq2,saltsq3) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            
            // Prepared Statement
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, salt);
            pstmt.setString(4, sq1);
            pstmt.setString(5, sq2);
            pstmt.setString(6, sq3);
            pstmt.setString(7, saltsq1);
            pstmt.setString(8, saltsq2);
            pstmt.setString(9, saltsq3);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void updateLockedUser(String username){
        //String sql = "UPDATE users "
        //        + "SET role = 1, "
        //        + "locked = 1 "
        //        + "WHERE username = '" + username 
        //        + "';";
        String sql = "UPDATE users SET role=1, locked = 1 WHERE username=?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void updateUnlockUser(String username){
        //String sql = "UPDATE users "
        //        + "SET role = 2, "
        //        + "locked = 0 "
        //        + "WHERE username = '" + username 
        //        + "';";
        String sql = "UPDATE users SET role=2, locked = 0 WHERE username=?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void updatePassword(String pw, String salt, String username){
        String sql = "UPDATE users SET password=?, salt=? WHERE username=?";

        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pw);
            pstmt.setString(2, salt);
            pstmt.setString(3, username);
            pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void updateUserRole(int role, String username){
        String sql = "UPDATE users SET role=? WHERE username=?";

        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, role);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public ArrayList<History> getHistory(){
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }
    
    public ArrayList<History> getUserHistory(String username){
        String sql = "SELECT id, username, name, stock, timestamp FROM history WHERE username ='" + username + "';";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }
    
    public ArrayList<Logs> getLogs(){
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                logs.add(new Logs(rs.getInt("id"),
                                   rs.getString("event"),
                                   rs.getString("username"),
                                   rs.getString("desc"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return logs;
    }
    
    public void purchaseProduct(int new_stocks, String name){
        // Step 1: Update stocks
        //String sql = "UPDATE product "
        //        + "SET stock =, " 
        //        + "WHERE name = '" + product_name
        //        + "';";
        String sql = "UPDATE product SET stock=? WHERE name=?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, new_stocks);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
      
    }
    
    
    public ArrayList<Product> getProduct(){
        String sql = "SELECT id, name, stock, price FROM product";
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return products;
    }
    
    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, password, role, salt, SQ1, SQ2, SQ3, saltSq1, saltSq2, saltSq3, locked FROM users";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password"),
                                   rs.getInt("role"),
                                   rs.getString("salt"),
                                   rs.getString("SQ1"),
                                   rs.getString("SQ2"),
                                   rs.getString("SQ3"),
                                   rs.getString("saltSq1"),
                                   rs.getString("saltSq2"),
                                   rs.getString("saltSq3"),
                                   rs.getInt("locked")));
            }
        } catch (Exception ex) {}
        return users;
    }
    
     public User getUserWhere(String currentUser){
        String sql = "SELECT id, username, password, role, salt, SQ1, SQ2, SQ3, saltSq1, saltSq2, saltSq3, locked FROM users WHERE username ='" + currentUser + "';";
        User user = null;
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            user = new User(rs.getInt("id"),
                             rs.getString("username"),
                             rs.getString("password"),
                             rs.getInt("role"),
                             rs.getString("salt"),
                             rs.getString("SQ1"),
                             rs.getString("SQ2"),
                             rs.getString("SQ3"),
                             rs.getString("saltSq1"),
                             rs.getString("saltSq2"),
                             rs.getString("saltSq3"),
                             rs.getInt("locked"));
            }
        catch (Exception ex) {
            System.out.print(ex);
        }
        
        return user;
    }

    // changed to prepared statement
    public void addUser(String username, String password, int role, String salt, String sq1, String sq2, String sq3, String saltsq1, String saltsq2, String saltsq3) {
        // String sql = "INSERT INTO users(username,password,role,salt,sq1,sq2,sq3,saltsq1,saltsq2,saltsq3) VALUES('" + username + "','" + password + "','" + role + "','" + salt + "','" + sq1 + "','" + sq2 + "','" + sq3 + "','" + saltsq1 + "','" + saltsq2 + "','" + saltsq3 + "')";
        String sql = "INSERT INTO users(username,password,role,salt,sq1,sq2,sq3,saltsq1,saltsq2,saltsq3) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            
            // Prepared Statement
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setInt(3, role);
            pstmt.setString(4, salt);
            pstmt.setString(5, sq1);
            pstmt.setString(6, sq2);
            pstmt.setString(7, sq3);
            pstmt.setString(8, saltsq1);
            pstmt.setString(9, saltsq2);
            pstmt.setString(10, saltsq3);
            pstmt.executeUpdate();
            System.out.println("Sample User Added");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    // changed to prepared statement
    public void removeUser(String username) {
        String sql = "DELETE FROM users WHERE username=?";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            System.out.println("User " + username + " has been deleted.");
            
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public Product getProduct(String name){
        String sql = "SELECT name, stock, price FROM product WHERE name='" + name + "';";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            product = new Product(rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price"));
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return product;
    }
    
    public void updateProduct(int id, String name, int stock, double price){
        String sql = "UPDATE product SET name=?, stock=?, price=? WHERE id=?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            //Statement stmt = conn.createStatement()){
            //stmt.execute(sql);
            
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void deleteProduct(int id){
        String sql = "DELETE FROM product WHERE id=?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
}