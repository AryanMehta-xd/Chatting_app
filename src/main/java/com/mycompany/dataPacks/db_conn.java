package com.mycompany.dataPacks;

import java.sql.*;

public class db_conn {
    public Connection db_Connection;
    private String db_user = "admin_Chat";
    private String db_pass = "chatting_app_2023";
    private String db_connect = "jdbc:mysql://db-chatting-app.cybqlqagqdu6.ap-south-1.rds.amazonaws.com:3306/chatting_app";
    
    public db_conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db_Connection = DriverManager.getConnection(db_connect,db_user,db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
