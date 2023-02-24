
package View;

import Controller.SQLite;
import Controller.PasswordHashing;

import Model.User;
import java.util.ArrayList;

public class Register extends javax.swing.JPanel {

    public Frame frame;
    public SQLite sqlite;
    
    public Register() {
        initComponents();
    }
    
    public void init(SQLite sqlite){
        this.sqlite = sqlite;   
    }

    public void reset(){
        usernameFld.setText("");
        passwordFld.setText("");
        confpassFld.setText("");
        registerErrorMsg.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        confpassFld = new javax.swing.JPasswordField();
        sqFld1 = new javax.swing.JPasswordField();
        sqFld2 = new javax.swing.JPasswordField();
        sqFld3 = new javax.swing.JPasswordField();
        registerErrorMsg = new javax.swing.JLabel();

        setFocusTraversalPolicyProvider(true);

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        passwordFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFldActionPerformed(evt);
            }
        });

        confpassFld.setBackground(new java.awt.Color(240, 240, 240));
        confpassFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confpassFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confpassFld.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sqFld1.setBackground(new java.awt.Color(240, 240, 240));
        sqFld1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sqFld1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sqFld1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Where were you when you had your first kiss?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        sqFld1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqFld1ActionPerformed(evt);
            }
        });

        sqFld2.setBackground(new java.awt.Color(240, 240, 240));
        sqFld2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sqFld2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sqFld2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "What was the name of your first stuffed animal? ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        sqFld2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqFld2ActionPerformed(evt);
            }
        });

        sqFld3.setBackground(new java.awt.Color(240, 240, 240));
        sqFld3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sqFld3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sqFld3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "What is your mother's maiden name?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        sqFld3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqFld3ActionPerformed(evt);
            }
        });

        registerErrorMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerErrorMsg.setForeground(new java.awt.Color(255, 51, 0));
        registerErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerErrorMsg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerErrorMsg.setPreferredSize(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameFld, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(passwordFld)
                    .addComponent(confpassFld)
                    .addComponent(sqFld1)
                    .addComponent(sqFld2)
                    .addComponent(registerErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sqFld3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confpassFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sqFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sqFld2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(sqFld3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String submittedUsername = usernameFld.getText();
        String submittedPassword = String.valueOf(passwordFld.getPassword());  
        String submittedConfPassword = String.valueOf(confpassFld.getPassword()); 
        
        String submittedSq1 = String.valueOf(sqFld1.getPassword());  
        String submittedSq2 = String.valueOf(sqFld2.getPassword()); 
        String submittedSq3 = String.valueOf(sqFld3.getPassword()); 
        
        boolean requirementsClear = false;
        
        if (submittedUsername.equals("") || submittedPassword.equals("") || submittedConfPassword.equals("") || submittedSq1.equals("") || submittedSq2.equals("") || submittedSq3.equals("") ){
            requirementsClear = false;
            registerErrorMsg.setText("Registration Failed. All fields must not be empty.");
        }
        
        
        // Validation
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            String name = users.get(nCtr).getUsername();
            requirementsClear = false;
            
            // Case 1: Empty Fields
            if (submittedUsername.equals("") || submittedPassword.equals("") || submittedConfPassword.equals("") || submittedSq1.equals("") || submittedSq2.equals("") || submittedSq3.equals("") ){
                requirementsClear = false;
                registerErrorMsg.setText("Registration Failed. All fields must not be empty.");
                break;
            }
            // Case 2: Username already taken
            else if(name.equalsIgnoreCase(submittedUsername)){
                requirementsClear = false;
                registerErrorMsg.setText("Registration Failed. Username already taken.");
                break;
            }
            // Case 3: Password and Confirmation Password don't match
            else if(!submittedPassword.equals(submittedConfPassword)){
                requirementsClear = false;
                registerErrorMsg.setText("Registration Failed. Passwords don't match.");
                break;
            }
            // Case 4: Add password restrictions
            else if(!submittedPassword.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")){
                requirementsClear = false;
                registerErrorMsg.setText("Registration Failed. Password must be at least 8 characters and contain at least 1 uppercase letter, at least 1 lowercase letter, at least 1 digit, and at least 1 special character.");
                break;
            }
            // Case 5: Register successful.
            else{
                requirementsClear = true;
            }
        }
        
        if(requirementsClear){
            String salt = PasswordHashing.getSaltvalue(30);
            String hashedPw = PasswordHashing.generateSecurePassword(submittedPassword, salt);
            
            String saltSq1 = PasswordHashing.getSaltvalue(30);
            String hashedSq1 = PasswordHashing.generateSecurePassword(submittedSq1, saltSq1);
            
            String saltSq2 = PasswordHashing.getSaltvalue(30);
            String hashedSq2 = PasswordHashing.generateSecurePassword(submittedSq2, saltSq2);
            
            String saltSq3 = PasswordHashing.getSaltvalue(30);
            String hashedSq3 = PasswordHashing.generateSecurePassword(submittedSq3, saltSq3);
            
            frame.registerAction(submittedUsername, hashedPw, salt, hashedSq1, hashedSq2, hashedSq3, saltSq1, saltSq2, saltSq3);
        }

        
    }//GEN-LAST:event_registerBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed

    private void passwordFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFldActionPerformed

    private void sqFld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqFld1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqFld1ActionPerformed

    private void sqFld2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqFld2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqFld2ActionPerformed

    private void sqFld3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqFld3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqFld3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPasswordField confpassFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel registerErrorMsg;
    private javax.swing.JPasswordField sqFld1;
    private javax.swing.JPasswordField sqFld2;
    private javax.swing.JPasswordField sqFld3;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
