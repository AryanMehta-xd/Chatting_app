package com.mycompany.resources;

import com.mycompany.dataPacks.*;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class main_page extends javax.swing.JFrame implements MessageReceivedCallbacbk{
    
    //constructor Declaration
    private imageMethods im = new imageMethods();
    private PreparedStatement ps1,ps2,ps3;
    private ResultSet rs1,rs2,rs3;
    private db_conn db_var = new db_conn();
    private Client cl;
    private check_friend_number chk = new check_friend_number();
    private new_request_confirm new_req;
    
    //global Variable
    private String send_path = "src/main/java/com/mycompany/Images/icons8_paper_plane_24px.png";
    private String username;    
    private String msg;
    private String receiver_username;
    private String[] full_received_msg;
    private boolean not_pan_status = false;
    private boolean notification_status;
    
    public main_page(String user) {
        initComponents();
        this.username = user;
        init();
        new_req = new new_request_confirm(username);
    }

    public void init(){
        
        but_send.setIcon(im.reSize(send_path, but_send));
        lbl_img.setIcon(im.getImage(lbl_img,username));
        
        but_logout.setIcon(im.reSize("src/main/java/com/mycompany/Images/icons8_Logout_64px.png", but_logout));
        but_quit.setIcon(im.reSize("src/main/java/com/mycompany/Images/icons8_shutdown_64px_1.png", but_quit));
        
        contact_list_pan.setLayout(new MigLayout());
        
        lbl_add_new_friend.setIcon(im.reSize("src/main/java/com/mycompany/Images/icons8_Add_User_Group_Woman_Man_64px.png", lbl_add_new_friend));
        
        checkRequestStatus();
        
        try {
            cl = new Client(username,this);
            cl.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        if(chk.friend_num_sender(username)||chk.friend_num_receiver(username)){
            showFriends();
            pan_showFriend.setVisible(true);
            pan_no_friend.setVisible(false);
        }
        setVisible(true);
        
    }
    
    @Override
    public void onMessageReceive(String sender, String rev, String msg) {
        for(Component component:contact_list_pan.getComponents()){
            if(component instanceof contact_tab){
                contact_tab con_tab = (contact_tab)component;
                
                if(con_tab.getReceiverName().equals(sender)){
                    con_tab.setMsgLabelVisible(true);
                }
            }
        }
    }
    
    Thread methodThread = new Thread(() -> {
        while (isVisible()) {
            checkRequestStatus();
            try {
                Thread.sleep(3000); // 1 second interval
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    
    private void checkRequestStatus(){
        try {
            ps2 = db_var.db_Connection.prepareStatement("select * from friend_request where receiver_username = ? and status = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ps2.setString(1, username);
            ps2.setString(2, "pending");
            rs2 = ps2.executeQuery();
            
            if(rs2.next()){
                lbl_new_request.setIcon(im.reSize("src/main/java/com/mycompany/Images/icons8_alarm_24px_2.png", lbl_new_request));
                notification_status = true;
            }else{
                lbl_new_request.setIcon(im.reSize("src/main/java/com/mycompany/Images/icons8_bell_24px.png", lbl_new_request));
                notification_status = false;
            }
            pan_top_buts.revalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void showFriends(){
        try {
            ps1 = db_var.db_Connection.prepareStatement("select receiver_username from friend_request where sender_username = ? and status = ?");
            ps1.setString(1, username);
            ps1.setString(2, "accepted");
            rs1 = ps1.executeQuery();
            
            while(rs1.next()){
                addPanels(rs1.getString("receiver_username"));
            }
            
            ps3 = db_var.db_Connection.prepareStatement("select sender_username from friend_request where receiver_username = ? and status = ?");
            ps3.setString(1, username);
            ps3.setString(2, "accepted");
            rs3 = ps3.executeQuery();
            
            while(rs3.next()){
                addPanels(rs3.getString("sender_username"));
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
        pan_top_buts = new javax.swing.JPanel();
        but_logout = new javax.swing.JButton();
        but_quit = new javax.swing.JButton();
        lbl_new_request = new javax.swing.JLabel();
        lbl_add_new_friend = new javax.swing.JLabel();
        pan_msg = new javax.swing.JPanel();
        pan_noChatOpen = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pan_chatOpen = new javax.swing.JPanel();
        but_send = new javax.swing.JButton();
        tf_send = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        pan_msg_det = new javax.swing.JPanel();
        lbl_username_chat = new javax.swing.JLabel();
        chat_rev_prof_image = new javax.swing.JLabel();
        lbl_user_status = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pan_contact = new javax.swing.JPanel();
        pan_no_friend = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pan_showFriend = new javax.swing.JPanel();
        tf_search_user = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        contact_list_pan = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        pan_top_buts.setBackground(new java.awt.Color(102, 204, 255));
        pan_top_buts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        but_logout.setBackground(new java.awt.Color(102, 204, 255));
        but_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_logoutActionPerformed(evt);
            }
        });

        but_quit.setBackground(new java.awt.Color(102, 204, 255));
        but_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_quitActionPerformed(evt);
            }
        });

        lbl_new_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_new_requestMouseClicked(evt);
            }
        });

        lbl_add_new_friend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_add_new_friendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pan_top_butsLayout = new javax.swing.GroupLayout(pan_top_buts);
        pan_top_buts.setLayout(pan_top_butsLayout);
        pan_top_butsLayout.setHorizontalGroup(
            pan_top_butsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_top_butsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but_quit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_add_new_friend, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_new_request, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pan_top_butsLayout.setVerticalGroup(
            pan_top_butsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_top_butsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan_top_butsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_quit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(but_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(lbl_new_request, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_add_new_friend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pan_topLayout = new javax.swing.GroupLayout(pan_top);
        pan_top.setLayout(pan_topLayout);
        pan_topLayout.setHorizontalGroup(
            pan_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_topLayout.createSequentialGroup()
                .addComponent(pan_top_buts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pan_topLayout.setVerticalGroup(
            pan_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(pan_top_buts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pan_msg.setLayout(new java.awt.CardLayout());

        pan_noChatOpen.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("No Chat Open");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pan_noChatOpenLayout = new javax.swing.GroupLayout(pan_noChatOpen);
        pan_noChatOpen.setLayout(pan_noChatOpenLayout);
        pan_noChatOpenLayout.setHorizontalGroup(
            pan_noChatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_noChatOpenLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        pan_noChatOpenLayout.setVerticalGroup(
            pan_noChatOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_noChatOpenLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
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

        pan_msg_det.setBackground(new java.awt.Color(255, 255, 255));
        pan_msg_det.setPreferredSize(new java.awt.Dimension(262, 50));
        pan_msg_det.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_username_chat.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        pan_msg_det.add(lbl_username_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 6, 200, 20));

        chat_rev_prof_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pan_msg_det.add(chat_rev_prof_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        lbl_user_status.setToolTipText("");
        pan_msg_det.add(lbl_user_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan_msg_det, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pan_msg_det, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap()
                .addComponent(tf_search_user, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        pan_showFriendLayout.setVerticalGroup(
            pan_showFriendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan_showFriendLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_search_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
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

    private void but_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_sendActionPerformed
        msg = tf_send.getText();
        if(!msg.equals("")){
            cl.sendMessage(username, receiver_username, msg);
            tf_send.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Can't Send Empty Msg");
        }
    }//GEN-LAST:event_but_sendActionPerformed

    private void addPanels(String user_name){
        contact_tab con_tab = new contact_tab(user_name);
                
                con_tab.setPanelListener(new PanelClickListener() {
                    @Override
                    public void onPanelClick(String user) {
                        receiver_username = user;
                        lbl_username_chat.setText(user);
                        chat_rev_prof_image.setIcon(im.getImage(chat_rev_prof_image, user));
                        pan_chatOpen.setVisible(true);
                        pan_noChatOpen.setVisible(false);
                        con_tab.setMsgLabelVisible(false);
                    }
                });
                
                contact_list_pan.add(con_tab,"wrap");
    }
    
    private void tf_search_userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search_userKeyReleased
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tf_search_userKeyReleased

    private void but_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_logoutActionPerformed
        dispose();
        cl.userLogout();
        new_req.dispose();
        new login_page();
    }//GEN-LAST:event_but_logoutActionPerformed

    private void but_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_quitActionPerformed
        cl.userDisconnect();
        new_req.dispose();
        dispose();
    }//GEN-LAST:event_but_quitActionPerformed

    private void lbl_add_new_friendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_add_new_friendMouseClicked
        new addFriend_main(username);
    }//GEN-LAST:event_lbl_add_new_friendMouseClicked

    private void lbl_new_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_new_requestMouseClicked
        if(notification_status==true){
            if(not_pan_status==false){        
                new_req.setLocationRelative(lbl_new_request);
                new_req.setVisible(true);
                not_pan_status = true;
                lbl_new_request.setIcon(im.reSize("src/main/java/com/mycompany/Images/icons8_bell_24px.png", lbl_new_request));
                pan_top_buts.revalidate();
            }else{
                new_req.dispose();
                not_pan_status = false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No new Notifications!");
        }
    }//GEN-LAST:event_lbl_new_requestMouseClicked

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
    private javax.swing.JButton but_logout;
    private javax.swing.JButton but_quit;
    private javax.swing.JButton but_send;
    private javax.swing.JLabel chat_rev_prof_image;
    private javax.swing.JLayeredPane contact_list_pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_add_new_friend;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_new_request;
    private javax.swing.JLabel lbl_user_status;
    private javax.swing.JLabel lbl_username_chat;
    private javax.swing.JPanel pan_chatOpen;
    private javax.swing.JPanel pan_contact;
    private javax.swing.JPanel pan_msg;
    private javax.swing.JPanel pan_msg_det;
    private javax.swing.JPanel pan_noChatOpen;
    private javax.swing.JPanel pan_no_friend;
    private javax.swing.JPanel pan_showFriend;
    private javax.swing.JPanel pan_top;
    private javax.swing.JPanel pan_top_buts;
    private javax.swing.JTextField tf_search_user;
    private javax.swing.JTextField tf_send;
    // End of variables declaration//GEN-END:variables

    
}
