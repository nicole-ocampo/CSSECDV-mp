
package View;

import Controller.SQLite;
import Controller.PasswordHashing;

import Model.User;
import java.util.ArrayList;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  

public class Login extends javax.swing.JPanel {

    public Frame frame;
    public SQLite sqlite;
    
    // additional Login variables
    public int invalidAttempts = 0;
    
    public Login() {
        initComponents();
    }

    public void init(SQLite sqlite){
        this.sqlite = sqlite;
        
//        // Add sample users      
//        // admin
//        String salt = PasswordHashing.getSaltvalue(30);
//        String hashedPw = PasswordHashing.generateSecurePassword("Hello12!", salt);
//        
//        String saltSq1 = PasswordHashing.getSaltvalue(30);
//        String hashedSq1 = PasswordHashing.generateSecurePassword("manila", saltSq1);
//        
//        String saltSq2 = PasswordHashing.getSaltvalue(30);
//        String hashedSq2 = PasswordHashing.generateSecurePassword("lily", saltSq2);
//        
//        String saltSq3 = PasswordHashing.getSaltvalue(30);
//        String hashedSq3 = PasswordHashing.generateSecurePassword("delacruz", saltSq3);
//        
//        sqlite.addUser("admin", hashedPw, 5, salt, hashedSq1, hashedSq2, hashedSq3, saltSq1, saltSq2, saltSq3);
//
//        // manager
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("Hello12!", salt);
//        
//        saltSq1 = PasswordHashing.getSaltvalue(30);
//        hashedSq1 = PasswordHashing.generateSecurePassword("manila", saltSq1);
//        
//        saltSq2 = PasswordHashing.getSaltvalue(30);
//        hashedSq2 = PasswordHashing.generateSecurePassword("lily", saltSq2);
//        
//        saltSq3 = PasswordHashing.getSaltvalue(30);
//        hashedSq3 = PasswordHashing.generateSecurePassword("delacruz", saltSq3);
//        
//        sqlite.addUser("manager", hashedPw, 4, salt, hashedSq1, hashedSq2, hashedSq3, saltSq1, saltSq2, saltSq3);
//
//        // staff
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("Hello12!", salt);
//        
//        saltSq1 = PasswordHashing.getSaltvalue(30);
//        hashedSq1 = PasswordHashing.generateSecurePassword("manila", saltSq1);
//        
//        saltSq2 = PasswordHashing.getSaltvalue(30);
//        hashedSq2 = PasswordHashing.generateSecurePassword("lily", saltSq2);
//        
//        saltSq3 = PasswordHashing.getSaltvalue(30);
//        hashedSq3 = PasswordHashing.generateSecurePassword("delacruz", saltSq3);
//        
//        sqlite.addUser("staff", hashedPw, 3, salt, hashedSq1, hashedSq2, hashedSq3, saltSq1, saltSq2, saltSq3);
//
//        
//        // client1
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("Hello12!", salt);
//        
//        saltSq1 = PasswordHashing.getSaltvalue(30);
//        hashedSq1 = PasswordHashing.generateSecurePassword("manila", saltSq1);
//        
//        saltSq2 = PasswordHashing.getSaltvalue(30);
//        hashedSq2 = PasswordHashing.generateSecurePassword("lily", saltSq2);
//        
//        saltSq3 = PasswordHashing.getSaltvalue(30);
//        hashedSq3 = PasswordHashing.generateSecurePassword("delacruz", saltSq3);
//        
//        sqlite.addUser("client1", hashedPw, 2, salt, hashedSq1, hashedSq2, hashedSq3, saltSq1, saltSq2, saltSq3);
//
//
//        // client2
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("Hello12!", salt);
//        
//        saltSq1 = PasswordHashing.getSaltvalue(30);
//        hashedSq1 = PasswordHashing.generateSecurePassword("manila", saltSq1);
//        
//        saltSq2 = PasswordHashing.getSaltvalue(30);
//        hashedSq2 = PasswordHashing.generateSecurePassword("lily", saltSq2);
//        
//        saltSq3 = PasswordHashing.getSaltvalue(30);
//        hashedSq3 = PasswordHashing.generateSecurePassword("delacruz", saltSq3);
//        
//        sqlite.addUser("client2", hashedPw, 2, salt, hashedSq1, hashedSq2, hashedSq3, saltSq1, saltSq2, saltSq3);

        // Get current users
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            String name = users.get(nCtr).getUsername();
            String pw = users.get(nCtr).getPassword();
            String sq1 = users.get(nCtr).getSq1();
            String sq2 = users.get(nCtr).getSq2();
            String sq3 = users.get(nCtr).getSq3();
            
            int lockedValue = users.get(nCtr).getLocked();
            
            System.out.println(name);
            System.out.println(pw);
            System.out.println(sq1);
            System.out.println(sq2);
            System.out.println(sq3);
            System.out.println(lockedValue);
        
            System.out.println("");
        }
    }
    
    public void reset(){
        usernameFld.setText("");
        passwordFld.setText("");
        logInErrorMsg.setText("");
    }
    
    public void registerSuccess(){
        logInErrorMsg.setText("Registration successful. You may now log in.");
    }
    
    public void changeSuccess(){
        logInErrorMsg.setText("Change password successful. You may now log in.");
    }
    
    public void logAttempt(String name, int attemptValue){
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
        String strDate = formatter.format(date);
        
        // case 1: password attempt that fails password restrictions
        switch (attemptValue) {
            case 1:
                {
                    String event = "NOTICE";
                    String description = name + " submitted an invalid password.";
                    sqlite.addLogs(event, name, description , strDate);
                    break;
                }
            case 2:
                {
                    String event = "NOTICE";
                    String description = name + " submitted the wrong password.";
                    sqlite.addLogs(event, name, description , strDate);
                    break;
                }
            case 3:
                {
                    String event = "WARNING";
                    String description = name + " exceeded the number of invalid attempts. Account is now locked.";
                    sqlite.addLogs(event, name, description , strDate);
                    break;
                }
            default:
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        forgetBtn = new javax.swing.JButton();
        logInErrorMsg = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(0, 153, 51));
        loginBtn.setText("LOGIN");
        loginBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0), 3));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        forgetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        forgetBtn.setForeground(new java.awt.Color(255, 102, 102));
        forgetBtn.setText("FORGOT PASSWORD");
        forgetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));
        forgetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetBtnActionPerformed(evt);
            }
        });

        logInErrorMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logInErrorMsg.setForeground(new java.awt.Color(255, 51, 0));
        logInErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logInErrorMsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld)
                    .addComponent(usernameFld, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(forgetBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logInErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String submittedUsername = usernameFld.getText();
        String submittedPassword = String.valueOf(passwordFld.getPassword()); 
        
        // rules for inputs
        String usernameRules = "[a-zA-Z0-9]*";
        String passwordRules = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])[a-zA-Z0-9#?!@$%^&*-]{8,}$";
        
    
        // Validation
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            String name = users.get(nCtr).getUsername();
            String pw = users.get(nCtr).getPassword();
            String salt = users.get(nCtr).getSalt();
            int user_role = users.get(nCtr).getRole();
            int lockedValue = users.get(nCtr).getLocked();
            
            if (submittedUsername.equals("") || submittedPassword.equals("")){
                logInErrorMsg.setText("Login Failed. All fields must not be empty.");
                break;
            }

            if(name.equalsIgnoreCase(submittedUsername)){
                if (lockedValue == 1){
                    usernameFld.setText("");
                    passwordFld.setText("");
                    logInErrorMsg.setText("Login Failed. Invalid Username or Password.");
                    break;
                }
                
                if (!submittedPassword.matches(passwordRules) && invalidAttempts < 3){
                    // logging for valid usernames with password attempts that fail password restrictions
                    logAttempt(name, 1);
                    
                    usernameFld.setText("");
                    passwordFld.setText("");
                    logInErrorMsg.setText("Login Failed. Invalid Username or Password");
                    invalidAttempts += 1;
                    break;
                }

                boolean verifiedPw = PasswordHashing.verifyPassword(submittedPassword, pw, salt);
                
                if (verifiedPw){
                    usernameFld.setText("");
                    passwordFld.setText("");
                    logInErrorMsg.setText("");
                    frame.setUp(name, user_role);
                    
                } else if (!verifiedPw && invalidAttempts < 3){
                    // logging for invalid passwords
                    logAttempt(name, 2);
                    
                    usernameFld.setText("");
                    passwordFld.setText("");
                    logInErrorMsg.setText("Login Failed. Invalid Username or Password");
                    invalidAttempts += 1;
                    break;
                } else if (invalidAttempts == 3){
                    // logging for locked accounts
                    logAttempt(name, 3);
                    
                    usernameFld.setText("");
                    passwordFld.setText("");
                    users.get(nCtr).setLocked(1);
                    users.get(nCtr).setRole(1);
                    sqlite.updateLockedUser(name);
                    logInErrorMsg.setText("Invalid attempts exceeded. Account is locked.");
                    break;
                }
            }
            
        }
        
        if (submittedUsername.equals("") || submittedPassword.equals(""))
            logInErrorMsg.setText("Login Failed. All fields must not be empty.");
        else if (!submittedUsername.matches(usernameRules)){
            logInErrorMsg.setText("Login Failed. Invalid Username or Password.");
        } else {
            usernameFld.setText("");
            passwordFld.setText("");
            logInErrorMsg.setText("Login Failed. Invalid Username or Password.");
        }

    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void forgetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetBtnActionPerformed
        frame.forgetNav();
    }//GEN-LAST:event_forgetBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgetBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logInErrorMsg;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
