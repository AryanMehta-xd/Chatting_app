package com.mycompany.resources;

import com.mycompany.dataPacks.PanelClickListener;
import com.mycompany.dataPacks.db_conn;
import com.mycompany.dataPacks.imageMethods;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.Icon;

/**
 *
 * @author Aryan Mehta
 */
public class contact_tab extends javax.swing.JPanel {

    private String username;
    private PanelClickListener listener;
    
    db_conn db_var = new db_conn();
    imageMethods im = new imageMethods();
    
    public contact_tab(String username) {
       initComponents();
        this.username = username;
        lbl_img.setSize(40,58);
        init();
    }

    public void init(){
        lbl_username.setText(username);
        Icon icon = im.getImage(lbl_img, username);
        lbl_msg_num.setSize(29,46);
        if (icon != null) {
            lbl_img.setIcon(icon);
        } else {
            lbl_img.setText("Image not found");
        }
            lbl_msg_num.setIcon(im.reSize("src/main/java/com/mycompany/Images/new_msg.png", lbl_msg_num));
            lbl_msg_num.setVisible(false);
            
    }
    
    public void setPanelListener(PanelClickListener panelClickListener){
        this.listener = panelClickListener;
    }
    
    public void setMsgLabelVisible(boolean status){
        lbl_msg_num.setVisible(status);
        revalidate();
    }
    
    public String getReceiverName(){
        return lbl_username.getText();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_username = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();
        lbl_msg_num = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        lbl_username.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        lbl_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_usernameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_usernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_usernameMouseExited(evt);
            }
        });

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_img.setOpaque(true);

        lbl_msg_num.setBackground(new java.awt.Color(153, 255, 153));
        lbl_msg_num.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_msg_num.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_msg_num.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lbl_msg_num, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbl_msg_num, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_usernameMouseClicked
        if(listener!=null){
            listener.onPanelClick(username);
        }
    }//GEN-LAST:event_lbl_usernameMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(Color.WHITE);
    }//GEN-LAST:event_formMouseExited

    private void lbl_usernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_usernameMouseEntered
        setBackground(Color.LIGHT_GRAY);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbl_usernameMouseEntered

    private void lbl_usernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_usernameMouseExited
        setBackground(Color.WHITE);
    }//GEN-LAST:event_lbl_usernameMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_msg_num;
    private javax.swing.JLabel lbl_username;
    // End of variables declaration//GEN-END:variables
}
