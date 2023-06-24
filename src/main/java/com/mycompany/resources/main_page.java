package com.mycompany.resources;

import com.mycompany.dataPacks.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.miginfocom.swing.MigLayout;

public class main_page extends javax.swing.JFrame {
    
    //constructor Declaration
    imageMethods im = new imageMethods();
    PreparedStatement ps;
    ResultSet rs;
    db_conn db_var = new db_conn();
    Client cl;
    check_friend_number chk = new check_friend_number();
    
    //global Variable
    private String send_path = "src/main/java/com/mycompany/Images/icons8_paper_plane_24px.png";
    private String username;
    private String msg;
    private String receiver_username;
    
    public main_page(String user) {
        initComponents();
        this.username = user;
        init();
    }

    public void init(){
        
        but_send.setIcon(im.reSize(send_path, but_send));
        lbl_img.setIcon(im.getImage(lbl_img,username));
        
        contact_list_pan.setLayout(new MigLayout());
        
        try {
            cl = new Client(username);
            cl.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(chk.friend_num(username)){
            showFriends();
            pan_showFriend.setVisible(true);
            pan_no_friend.setVisible(false);
        }
        setVisible(true);
    }
    
    private void showFriends(){
        try {
            ps = db_var.db_Connection.prepareStatement("select * from friend_request where sender_username = ? and status = ?");
            ps.setString(1, username);
            ps.setString(2, "accepted");
            rs = ps.executeQuery();
            
            while(rs.next()){
                contact_list_pan.add(new contact_tab(rs.getString("receiver_username")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pan_top = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pan_msg = new javax.swing.JPanel();
        pan_noChatOpen = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pan_chatOpen = new javax.swing.JPanel();
        but_send = new javax.swing.JButton();
        tf_send = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        pan_contact = new javax.swing.JPanel();
        pan_no_friend = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pan_showFriend = new javax.swing.JPanel();
        tf_search_user = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        contact_list_pan = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pan_top.setBackground(new java.awt.Color(255, 255, 255));

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_img.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("<html><p>|<br>|<br>|</p></html>");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout pan_topLayout = new javax.swing.GroupLayout(pan_top);
        pan_top.setLayout(pan_topLayout);
        pan_topLayout.setHorizontalGroup(
            pan_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_topLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pan_topLayout.setVerticalGroup(
            pan_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        pan_msg.setLayout(new java.awt.CardLayout());

        pan_noChatOpen.setBackground(new java.awt.Color(255, 102, 102));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan_noChatOpenLayout = new javax.swing.GroupLayout(pan_noChatOpen);
        pan_noChatOpen.setLayout(pan_noChatOpenLayout);
        pan_noChatOpenLayout.setHorizontalGroup(
            pan_noChatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_noChatOpenLayout.createSequentialGroup()
                .addContainerGap(404, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(193, 193, 193))
        );
        pan_noChatOpenLayout.setVerticalGroup(
            pan_noChatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_noChatOpenLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jButton1)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        pan_msg.add(pan_noChatOpen, "card2");

        pan_chatOpen.setBackground(new java.awt.Color(255, 255, 255));

        but_send.setOpaque(true);
        but_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_sendActionPerformed(evt);
            }
        });

        tf_send.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_send.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pan_chatOpenLayout = new javax.swing.GroupLayout(pan_chatOpen);
        pan_chatOpen.setLayout(pan_chatOpenLayout);
        pan_chatOpenLayout.setHorizontalGroup(
            pan_chatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_chatOpenLayout.createSequentialGroup()
                .addGroup(pan_chatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan_chatOpenLayout.createSequentialGroup()
                        .addComponent(tf_send, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_send, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pan_chatOpenLayout.setVerticalGroup(
            pan_chatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_chatOpenLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pan_chatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_send, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_send, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pan_msg.add(pan_chatOpen, "card3");

        pan_contact.setLayout(new java.awt.CardLayout());

        pan_no_friend.setBackground(new java.awt.Color(255, 255, 255));
        pan_no_friend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel1.setText("<html>No Friends Added!<br><center>Add to Chat</center></html>");

        javax.swing.GroupLayout pan_no_friendLayout = new javax.swing.GroupLayout(pan_no_friend);
        pan_no_friend.setLayout(pan_no_friendLayout);
        pan_no_friendLayout.setHorizontalGroup(
            pan_no_friendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_no_friendLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pan_no_friendLayout.setVerticalGroup(
            pan_no_friendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_no_friendLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pan_contact.add(pan_no_friend, "card2");

        pan_showFriend.setBackground(new java.awt.Color(255, 255, 255));
        pan_showFriend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_search_user.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        tf_search_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_search_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search_userKeyReleased(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contact_list_pan.setBackground(new java.awt.Color(255, 255, 255));
        contact_list_pan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contact_list_pan.setOpaque(true);

        javax.swing.GroupLayout contact_list_panLayout = new javax.swing.GroupLayout(contact_list_pan);
        contact_list_pan.setLayout(contact_list_panLayout);
        contact_list_panLayout.setHorizontalGroup(
            contact_list_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contact_list_panLayout.setVerticalGroup(
            contact_list_panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contact_list_pan);

        javax.swing.GroupLayout pan_showFriendLayout = new javax.swing.GroupLayout(pan_showFriend);
        pan_showFriend.setLayout(pan_showFriendLayout);
        pan_showFriendLayout.setHorizontalGroup(
            pan_showFriendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_showFriendLayout.createSequentialGroup()
                .addGroup(pan_showFriendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan_showFriendLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tf_search_user, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pan_showFriendLayout.setVerticalGroup(
            pan_showFriendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_showFriendLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_search_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pan_contact.add(pan_showFriend, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pan_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pan_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pan_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pan_chatOpen.setVisible(true);
        pan_noChatOpen.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void but_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_sendActionPerformed
        msg = tf_send.getText();
        cl.sendMessage(username, "xyz", msg);
    }//GEN-LAST:event_but_sendActionPerformed

    private void tf_search_userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search_userKeyReleased
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tf_search_userKeyReleased

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
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_page("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_send;
    private javax.swing.JLayeredPane contact_list_pan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JPanel pan_chatOpen;
    private javax.swing.JPanel pan_contact;
    private javax.swing.JPanel pan_msg;
    private javax.swing.JPanel pan_noChatOpen;
    private javax.swing.JPanel pan_no_friend;
    private javax.swing.JPanel pan_showFriend;
    private javax.swing.JPanel pan_top;
    private javax.swing.JTextField tf_search_user;
    private javax.swing.JTextField tf_send;
    // End of variables declaration//GEN-END:variables
}
