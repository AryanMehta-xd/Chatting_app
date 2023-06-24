package com.mycompany.resources;

import com.mycompany.dataPacks.PanelClickListener;
import com.mycompany.dataPacks.db_conn;
import com.mycompany.dataPacks.imageMethods;
import java.awt.Color;
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
        lbl_img.setSize(40,53);
        init();
    }

    public void init(){
        lbl_username.setText(username);
        Icon icon = im.getImage(lbl_img, username);
        if (icon != null) {
            lbl_img.setIcon(icon);
        } else {
            lbl_img.setText("Image not found");
        }
            lbl_status.setBackground(Color.GREEN);
    }
    
    public void setPanelListener(PanelClickListener panelClickListener){
        this.listener = panelClickListener;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_status = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_status.setBackground(new java.awt.Color(255, 255, 255));
        lbl_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_status.setOpaque(true);

        lbl_username.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        lbl_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_usernameMouseClicked(evt);
            }
        });

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_img.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_status, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_usernameMouseClicked
        if(listener!=null){
            listener.onPanelClick(username);
        }
    }//GEN-LAST:event_lbl_usernameMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_username;
    // End of variables declaration//GEN-END:variables
}
