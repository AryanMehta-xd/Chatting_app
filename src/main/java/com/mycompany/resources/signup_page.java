package com.mycompany.resources;

import com.mycompany.dataPacks.*;
import java.awt.Color;
import java.io.File;
import java.net.InetAddress;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Aryan Mehta
 */
public class signup_page extends javax.swing.JFrame {

    //global variable declaration
    private String path_default_img = "src/main/java/com/mycompany/Images/icons8_client_management_50px.png";
    private File img_file = new File(path_default_img);
    private String path_user_image="";
    private boolean imageset=false;
    private String username;
    private String full_name;
    private String mob_no;
    private String emailid;
    private String test_user;
    private String password;
    private int warning=0,img_default = 1;
    private int Status1,Status2,choice;
    
    //contructors
    imageMethods im = new imageMethods();
    db_conn db_var =  new db_conn();
    JFileChooser jFileChooser = new JFileChooser();
    PreparedStatement ps1,ps2;
    ResultSet rs;
    FileInputStream fileInput;
    
    public signup_page() {
        initComponents();
        init();
    }

    public void init(){
        setVisible(true);
        tf_profile_photo.setIcon(im.reSize(path_default_img, tf_profile_photo));
        lbl_warning.setVisible(false); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_full_name = new javax.swing.JTextField();
        tf_mobileNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        tf_profile_photo = new javax.swing.JLabel();
        but_reset_img = new javax.swing.JButton();
        but_createAccount = new javax.swing.JButton();
        lbl_warning = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_password = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Signup");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREATE ACCOUNT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("__________________________________________________________________________________________________________________________________________________");

        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel3.setText("Full Name :");

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel4.setText("Username :");

        tf_full_name.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_full_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_mobileNo.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_mobileNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel5.setText("Mobile No :");

        tf_username.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_usernameKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel6.setText("Email Id:");

        tf_email.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_profile_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_profile_photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_profile_photoMouseClicked(evt);
            }
        });

        but_reset_img.setBackground(new java.awt.Color(0, 0, 102));
        but_reset_img.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        but_reset_img.setForeground(new java.awt.Color(255, 255, 255));
        but_reset_img.setText("RESET");
        but_reset_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_reset_imgActionPerformed(evt);
            }
        });

        but_createAccount.setBackground(new java.awt.Color(0, 0, 102));
        but_createAccount.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        but_createAccount.setForeground(new java.awt.Color(255, 255, 255));
        but_createAccount.setText("CREATE ACCOUNT");
        but_createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_createAccountActionPerformed(evt);
            }
        });

        lbl_warning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel7.setText("Password :");

        tf_password.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_back.setBackground(new java.awt.Color(0, 0, 102));
        btn_back.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("BACK");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_createAccount)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_full_name)
                                .addComponent(tf_mobileNo)
                                .addComponent(tf_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addComponent(tf_email)
                                .addComponent(tf_password))
                            .addComponent(lbl_warning))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_profile_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but_reset_img))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lbl_warning)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_mobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tf_profile_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(but_reset_img)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_createAccount)
                    .addComponent(btn_back))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_profile_photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_profile_photoMouseClicked
        int response = jFileChooser.showSaveDialog(jPanel1);
        
        if (response==JFileChooser.APPROVE_OPTION) {
            img_file = jFileChooser.getSelectedFile();
            path_user_image = img_file.getAbsolutePath();
            
            tf_profile_photo.setIcon(im.reSize(path_user_image, tf_profile_photo));
            jPanel1.revalidate();
            imageset=true;
            img_default=0;
        }else if (response == JFileChooser.CANCEL_OPTION) {
            if (imageset) {
                tf_profile_photo.setIcon(im.reSize(path_user_image, tf_profile_photo));
            } else {
                tf_profile_photo.setIcon(im.reSize(path_default_img, tf_profile_photo));
                img_file = new File(path_default_img);
                img_default=1;
            }
            jPanel1.revalidate();
        }
    }//GEN-LAST:event_tf_profile_photoMouseClicked

    private void but_reset_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_reset_imgActionPerformed
        tf_profile_photo.setIcon(im.reSize(path_default_img, tf_profile_photo));
        img_file = new File(path_default_img);
        jPanel1.revalidate();
    }//GEN-LAST:event_but_reset_imgActionPerformed

    private void but_createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_createAccountActionPerformed
        username = tf_username.getText();
        full_name = tf_full_name.getText();
        mob_no = tf_mobileNo.getText();
        emailid = tf_email.getText();
        password = tf_password.getText();
        
        try {
            fileInput = new FileInputStream(img_file);
            if(username.equals("")||full_name.equals("")||mob_no.equals("")||emailid.equals("")){
                JOptionPane.showMessageDialog(null, "All Fields are Required!!");
            }else{
                if(img_default==1){
                    choice = JOptionPane.showConfirmDialog(null, "Using Default Profile Image!!\nCreate Account?");
                    if(choice == JOptionPane.NO_OPTION){
                        tf_profile_photo.requestFocus();
                    }else if(choice==JOptionPane.YES_OPTION){
                        img_default=0;
                    }
                    
                }
                if (warning==0&&img_default==0) {
                    ps1 = db_var.db_Connection.prepareStatement("insert into signup values(?,?,?,?,?)");
                    ps1.setString(1, username);
                    ps1.setString(2, full_name);
                    ps1.setString(3, mob_no);
                    ps1.setString(4, emailid);
                    ps1.setBinaryStream(5,fileInput,(int)(img_file.length()));
                    
                    ps2 = db_var.db_Connection.prepareStatement("insert into login values(?,?)");
                    ps2.setString(1, username);
                    ps2.setString(2, password);
                    
                    Status1 = ps1.executeUpdate();
                    Status2 = ps2.executeUpdate();
                    
                    if(Status1==1&&Status2==1){
                        JOptionPane.showMessageDialog(null, "Account Created Successfully!\nWelcome :"+username);
                        dispose();
                        new login_page();
                    }else{
                        JOptionPane.showMessageDialog(null, "Something went wrong!!");
                    }
                    
                }else if(warning==1){
                  JOptionPane.showMessageDialog(null,"Change Username!!");
                  tf_username.requestFocus();
                }
            } 
        }catch (Exception e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_but_createAccountActionPerformed

    private void tf_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_usernameKeyReleased
        try {
            test_user = tf_username.getText();
            
            ps1 = db_var.db_Connection.prepareStatement("select * from login where username = ?");
            ps1.setString(1, test_user);
            rs = ps1.executeQuery();
            
            if(test_user.equals("")){
                lbl_warning.setVisible(false);
            }else{
                if(rs.next()){
                    lbl_warning.setVisible(true);
                    lbl_warning.setForeground(Color.red);
                    lbl_warning.setText("Username Already Exists!!!");
                    warning=1;
                }else{
                    lbl_warning.setVisible(true);
                    lbl_warning.setForeground(Color.GREEN);
                    lbl_warning.setText("Username Available");
                    warning=0;
                }
            }
            
            jPanel1.revalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tf_usernameKeyReleased

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        new login_page();
    }//GEN-LAST:event_btn_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton but_createAccount;
    private javax.swing.JButton but_reset_img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_warning;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_full_name;
    private javax.swing.JTextField tf_mobileNo;
    private javax.swing.JTextField tf_password;
    private javax.swing.JLabel tf_profile_photo;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
