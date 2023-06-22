package com.mycompany.dataPacks;

import java.sql.*;

public class db_conn {
    public Connection db_Connection;
    private String db_user = "root";
    private String db_pass = "1234";
    private String db_connect = "jdbc:mysql://127.0.0.1:3306/chat_app";
    
    public db_conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db_Connection = DriverManager.getConnection(db_connect,db_user,db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
