package com.mycompany.dataPacks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aryan Mehta
 */
public class check_friend_number {

    private PreparedStatement ps1,ps2;
    private ResultSet rs1,rs2;
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
}
