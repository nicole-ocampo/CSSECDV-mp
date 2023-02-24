
package View;

import Controller.SQLite;
import Controller.PasswordHashing;

import Model.User;
import java.util.ArrayList;


public class ForgetPassword extends javax.swing.JPanel {

    public Frame frame;
    public SQLite sqlite;
        
    public ForgetPassword() {
        initComponents();
    }

    public void init(SQLite sqlite){
        this.sqlite = sqlite;
    }
    
    public void reset(){
        usernameFld.setText("");
        sqFld1.setText("");
        sqFld2.setText("");
        sqFld3.setText("");
        forgetErrorMsg.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        sqFld1 = new javax.swing.JPasswordField();
        sqFld2 = new javax.swing.JPasswordField();
        sqFld3 = new javax.swing.JPasswordField();
        nextBtn = new javax.swing.JButton();
        forgetErrorMsg = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sqFld1.setBackground(new java.awt.Color(240, 240, 240));
        sqFld1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sqFld1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sqFld1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Where were you when you had your first kiss?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sqFld2.setBackground(new java.awt.Color(240, 240, 240));
        sqFld2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sqFld2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sqFld2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "What was the name of your first stuffed animal?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sqFld3.setBackground(new java.awt.Color(240, 240, 240));
        sqFld3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sqFld3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sqFld3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "What is your mother's maiden name?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        nextBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 102, 102));
        nextBtn.setText("NEXT");
        nextBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        forgetErrorMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forgetErrorMsg.setForeground(new java.awt.Color(255, 51, 0));
        forgetErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back");
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
                    .addComponent(forgetErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sqFld1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sqFld2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sqFld3, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqFld2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqFld3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgetErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        String submittedUsername = usernameFld.getText();
        String submittedSq1 = String.valueOf(sqFld1.getPassword());  
        String submittedSq2 = String.valueOf(sqFld2.getPassword());  
        String submittedSq3 = String.valueOf(sqFld3.getPassword());  
        
        if (submittedUsername.equals("") || submittedSq1.equals("") || submittedSq1.equals("") || submittedSq3.equals(""))
            forgetErrorMsg.setText("Change Password Failed. All fields must not be empty.");
       
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            String name = users.get(nCtr).getUsername();
            String pw = users.get(nCtr).getPassword();
            
            String sq1 = users.get(nCtr).getSq1();
            String sq2 = users.get(nCtr).getSq2();
            String sq3 = users.get(nCtr).getSq3();
            
            String saltSq1 = users.get(nCtr).getSaltSq1();
            String saltSq2 = users.get(nCtr).getSaltSq2();
            String saltSq3 = users.get(nCtr).getSaltSq3();
            
            if (submittedUsername.equals("") || submittedSq1.equals("") || submittedSq1.equals("") || submittedSq3.equals("")){
                forgetErrorMsg.setText("Change Password Failed. All fields must not be empty.");
                break;
            }
            
            if(name.equalsIgnoreCase(submittedUsername)){
                boolean verifiedSq1 = PasswordHashing.verifyPassword(submittedSq1, sq1, saltSq1);
                boolean verifiedSq2 = PasswordHashing.verifyPassword(submittedSq2, sq2, saltSq2);
                boolean verifiedSq3 = PasswordHashing.verifyPassword(submittedSq3, sq3, saltSq3);
                
                if (verifiedSq1 && verifiedSq2 && verifiedSq3){
                    usernameFld.setText("");
                    sqFld1.setText("");
                    sqFld2.setText("");
                    sqFld3.setText("");
                    forgetErrorMsg.setText("");
                    frame.changeNav(submittedUsername);
                } else {
                    forgetErrorMsg.setText("Wrong username and/or answers.");
                } 
            }
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel forgetErrorMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPasswordField sqFld1;
    private javax.swing.JPasswordField sqFld2;
    private javax.swing.JPasswordField sqFld3;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
