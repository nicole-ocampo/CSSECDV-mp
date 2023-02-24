
package View;

import Controller.SQLite;
import Controller.PasswordHashing;

import Model.User;
import java.util.ArrayList;


public class ChangePassword extends javax.swing.JPanel {

    public Frame frame;
    public SQLite sqlite;
    private String currentUser;
        
    public ChangePassword() {
        initComponents();
    }

    public void init(SQLite sqlite){
        this.sqlite = sqlite;
    }
    
    public void reset(){
        changeFld.setText("");
        confchangeFld.setText("");
        changeErrorMsg.setText("");
    }
    
    public void setCurrentUser(String currentUser){
        this.currentUser = currentUser;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        changeFld = new javax.swing.JPasswordField();
        confchangeFld = new javax.swing.JPasswordField();
        changeBtn = new javax.swing.JButton();
        changeErrorMsg = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        changeFld.setBackground(new java.awt.Color(240, 240, 240));
        changeFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        changeFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        changeFld.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "NEW PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        confchangeFld.setBackground(new java.awt.Color(240, 240, 240));
        confchangeFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confchangeFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confchangeFld.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CONFIRM NEW PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        changeBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changeBtn.setForeground(new java.awt.Color(255, 102, 102));
        changeBtn.setText("CHANGE PASSWORD");
        changeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));
        changeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBtnActionPerformed(evt);
            }
        });

        changeErrorMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        changeErrorMsg.setForeground(new java.awt.Color(255, 51, 0));
        changeErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back to Login");
        backBtn.setToolTipText("");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(changeErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(changeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confchangeFld, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confchangeFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(changeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBtnActionPerformed
        String submittedPw = String.valueOf(changeFld.getPassword());
        String submittedconfPw = String.valueOf(confchangeFld.getPassword());
        User user = sqlite.getUserWhere(currentUser);
        
        boolean requirementsClear = false;
        
        if (submittedPw.equals("") || submittedconfPw.equals(""))
            changeErrorMsg.setText("Change Password Failed. All fields must not be empty.");
        else{
            // Ensure submitted passwords match
            if(!submittedPw.equals(submittedconfPw)){
                requirementsClear = false;
                changeErrorMsg.setText("Change Password Failed. Passwords don't match.");
            }
            
            // Implement password policies from register
            else if(!submittedPw.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")){
                requirementsClear = false;
                changeErrorMsg.setText("Change Password Failed. Password must be at least 8 characters and contain at least 1 uppercase letter, at least 1 lowercase letter, at least 1 digit, and at least 1 special character."); 
            }
            else{
                requirementsClear = true;
            }
        }
        
        if (requirementsClear){
            String salt = PasswordHashing.getSaltvalue(30);
            String hashedPw = PasswordHashing.generateSecurePassword(submittedPw, salt);
            
            sqlite.updatePassword(hashedPw, salt, currentUser);
            sqlite.updateUnlockUser(currentUser);
            
            frame.changePwSuccess();
        }
    }//GEN-LAST:event_changeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton changeBtn;
    private javax.swing.JLabel changeErrorMsg;
    private javax.swing.JPasswordField changeFld;
    private javax.swing.JPasswordField confchangeFld;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
