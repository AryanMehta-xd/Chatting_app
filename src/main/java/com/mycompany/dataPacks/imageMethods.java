package com.mycompany.dataPacks;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author Aryan Mehta
 */

public class imageMethods{
    
    ResultSet rs;
    PreparedStatement ps;
    
    public Icon reSize(String path,JLabel label){
        ImageIcon img = new ImageIcon(path);
        Image image  = img.getImage();
        Image imgScale = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(imgScale);
        
        return icon;
        
    }

    
    public Icon reSize(String path, JToggleButton tb) {
        ImageIcon img = new ImageIcon(path);
        Image image  = img.getImage();
        Image imgScale = image.getScaledInstance(tb.getWidth(), tb.getHeight(), Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(imgScale);
        
        return icon;
    }

    
    public Icon reSize(String path, JButton button) {
        ImageIcon img = new ImageIcon(path);
        Image image  = img.getImage();
        Image imgScale = image.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(imgScale);
        
        return icon;
    }
    
    public Icon getImage(JLabel label,String username){
        db_conn db_var = new db_conn();
        Icon rimg = null;
        try{
            ps = db_var.db_Connection.prepareStatement("select profile_img from signup where username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if(rs.next()){
                byte[] img = rs.getBytes("profile_img");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                
               rimg = new  ImageIcon(myimg);
              
            }
        }catch(Exception e){
            e.printStackTrace();}
        return rimg;      
    }
    
}