package com.mycompany.dataPacks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aryan Mehta
 */
public class db_friend_queries {

    private PreparedStatement ps1;
    private ResultSet rs1;
    private boolean status;
    
    db_conn db_var = new db_conn();
    
    public boolean friend_num_sender(String username){
        try {
            ps1 = db_var.db_Connection.prepareStatement("select receiver_username from friend_request where sender_username = ? and status = ?");
            ps1.setString(1, username);
            ps1.setString(2, "accepted");
            rs1 = ps1.executeQuery();
            
            status = rs1.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean friend_num_receiver(String username){
        try {
            ps1 = db_var.db_Connection.prepareStatement("select sender_username from friend_request where receiver_username = ? and status = ?");
            ps1.setString(1, username);
            ps1.setString(2, "accepted");
            rs1 = ps1.executeQuery();
            
            status = rs1.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean check_if_friend_sender(String sender_username,String rev_username){
        try {
            ps1 = db_var.db_Connection.prepareStatement("select * from friend_request where sender_username = ? and receiver_username = ? and status = ?");
            ps1.setString(1, sender_username);
            ps1.setString(2, rev_username);
            ps1.setString(3, "accepted");
            
            rs1 = ps1.executeQuery();
            
            status = rs1.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean check_if_friend_rev(String sender_username,String rev_username){
        try {
            ps1 = db_var.db_Connection.prepareStatement("select * from friend_request where sender_username = ? and receiver_username = ? and status = ?");
            ps1.setString(1, rev_username);
            ps1.setString(2, sender_username);
            ps1.setString(3, "accepted");
            
            rs1 = ps1.executeQuery();
            
            status = rs1.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public String checkUserStatus(String chk_username){
        String user_s = null;
        try {
            ps1 = db_var.db_Connection.prepareStatement("select user_status from user_status_tab where username = ?");
            ps1.setString(1, chk_username);
            rs1 = ps1.executeQuery();
            
            while(rs1.next()){
                return user_s = rs1.getString("user_status");
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user_s;
    }
}
