
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
        
        // Add sample users
//        String salt = PasswordHashing.getSaltvalue(30);
//        String hashedPw = PasswordHashing.generateSecurePassword("qwerty1234", salt);
//        sqlite.addUser("admin", hashedPw, 5, salt);
//        
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("qwerty1234", salt);
//        
//        sqlite.addUser("manager", hashedPw, 4, salt);
//        
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("qwerty1234", salt);
//        
//        sqlite.addUser("staff", hashedPw, 3, salt);
//        
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("qwerty1234", salt);
//        
//        sqlite.addUser("client1", hashedPw, 2, salt);
//        
//        salt = PasswordHashing.getSaltvalue(30);
//        hashedPw = PasswordHashing.generateSecurePassword("qwerty1234", salt);
//        
//        sqlite.addUser("client2", hashedPw, 2, salt);

        // Get current users
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            String name = users.get(nCtr).getUsername();
            String pw = users.get(nCtr).getPassword();
            int lockedValue = users.get(nCtr).getLocked();
            
            System.out.println(name);
            System.out.println(pw);
            System.out.println(lockedValue);
        
            System.out.println("");
        }
    }
    
    public void reset(){
        logInErrorMsg.setText("");
    }
    
    public void registerSuccess(){
        logInErrorMsg.setText("Registration successful. You may now log in.");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
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

        logInErrorMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logInErrorMsg.setForeground(new java.awt.Color(255, 51, 0));
        logInErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logInErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logInErrorMsg)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String submittedUsername = usernameFld.getText();
        String submittedPassword = String.valueOf(passwordFld.getPassword());  
        
        // Validation
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            String name = users.get(nCtr).getUsername();
            String pw = users.get(nCtr).getPassword();
            String salt = users.get(nCtr).getSalt();
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

                boolean verifiedPw = PasswordHashing.verifyPassword(submittedPassword, pw, salt);
                
                if (verifiedPw){
                    usernameFld.setText("");
                    passwordFld.setText("");
                    logInErrorMsg.setText("");
                    frame.mainNav();
                } else if (!verifiedPw && invalidAttempts < 3){
                    
                    // logging for invalid passwords
                    String event = "NOTICE";
                    String description = name + " submitted the wrong password.";
                    Date date = new Date();  
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
                    String strDate = formatter.format(date); 
                    sqlite.addLogs(event, name, description , strDate);
                    //System.out.println(strDate);
                    
                    usernameFld.setText("");
                    passwordFld.setText("");
                    logInErrorMsg.setText("Login Failed. Invalid Username or Password");
                    invalidAttempts += 1;
                    break;
                } else if (invalidAttempts == 3){
                    
                    // logging for locked accounts
                    String event = "WARNING";
                    String description = name + " exceeded the number of invalid attempts. Account is now locked.";
                    Date date = new Date();  
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
                    String strDate = formatter.format(date); 
                    sqlite.addLogs(event, name, description , strDate);
                    
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

    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logInErrorMsg;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
