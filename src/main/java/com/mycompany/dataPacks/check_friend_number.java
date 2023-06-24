package com.mycompany.dataPacks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aryan Mehta
 */
public class check_friend_number {

    private PreparedStatement ps;
    private ResultSet rs;
    
    db_conn db_var = new db_conn();
    
    public boolean friend_num(String username){
        boolean status = true;
        try {
            ps = db_var.db_Connection.prepareStatement("select receiver_username from friend_request where sender_username = ? and status = ?");
            ps.setString(1, username);
            ps.setString(2, "accepted");
            rs = ps.executeQuery();
            
            if(rs.next()){
                status = true;
            }else{
                status = false;
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
}
