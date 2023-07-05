package com.mycompany.resources;

import com.mycompany.dataPacks.db_conn;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mycompany.dataPacks.imageMethods;

/**
 *
 * @author Aryan Mehta
 */
public class login_page extends javax.swing.JFrame {
    
    //global variable declaration
    private String username;
    private String password;
    private String path_hide = "src/main/java/com/mycompany/Images/icons8_hide_30px.png";
    private String path_show= "src/main/java/com/mycompany/Images/icons8_eye_30px.png";
    
    
    //Class Objects Declaration
    db_conn db_var = new db_conn();
    ResultSet rs;
    imageMethods im = new imageMethods();
    
    public login_page() {
        initComponents();
        init();
    }

    public void init(){
        setVisible(true);
        tf_username.requestFocus();
        //but_show_hide.setIcon(im.reSize(path_show,but_show_hide));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_pan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        but_login = new javax.swing.JButton();
        but_signup = new javax.swing.JButton();
        tf_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setUndecorated(true);
        setResizable(false);

        main_pan.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chatting App");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");

        tf_username.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        tf_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tf_username.setOpaque(true);
        tf_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_usernameKeyPressed(evt);
            }
        });

        but_login.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        but_login.setText("LOGIN");
        but_login.setBorderPainted(false);
        but_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_loginActionPerformed(evt);
            }
        });
        but_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                but_loginKeyPressed(evt);
            }
        });

        but_signup.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        but_signup.setText("SIGNUP");
        but_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_signupActionPerformed(evt);
            }
        });
        but_signup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                but_signupKeyPressed(evt);
            }
        });

        tf_password.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        tf_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tf_password.setOpaque(true);
        tf_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_passwordKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");

        javax.swing.GroupLayout main_panLayout = new javax.swing.GroupLayout(main_pan);
        main_pan.setLayout(main_panLayout);
        main_panLayout.setHorizontalGroup(
            main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(main_panLayout.createSequentialGroup()
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(main_panLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_username, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tf_password)))
                    .addGroup(main_panLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(but_signup)
                        .addGap(68, 68, 68)
                        .addComponent(but_login)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        main_panLayout.setVerticalGroup(
            main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(tf_username))
                .addGap(27, 27, 27)
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(tf_password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(main_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_signup)
                    .addComponent(but_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_loginActionPerformed
        userLogin();
    }//GEN-LAST:event_but_loginActionPerformed

    private void but_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_signupActionPerformed
        dispose();
        new signup_page();
    }//GEN-LAST:event_but_signupActionPerformed

    private void tf_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_usernameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER ){
            userLogin();
        }else if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_tf_usernameKeyPressed

    private void but_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_but_loginKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_but_loginKeyPressed

    private void but_signupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_but_signupKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_but_signupKeyPressed

    private void tf_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_passwordKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            dispose();
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            userLogin();
        }
    }//GEN-LAST:event_tf_passwordKeyPressed

    private void userLogin(){
        try {
            username = tf_username.getText();
            password = tf_password.getText();

            PreparedStatement ps = db_var.db_Connection.prepareStatement("select * from login where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if(rs.next()){
                dispose();
                new main_page(username);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Credentials");
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went Wrong!!");
        }
    }
    
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
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_login;
    private javax.swing.JButton but_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel main_pan;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
