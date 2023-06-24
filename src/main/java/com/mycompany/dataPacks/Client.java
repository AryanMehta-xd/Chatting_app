package com.mycompany.dataPacks;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends Thread{
    private String username;
    private DataOutputStream output;
    private DataInputStream input;
    private Socket socket;
    
    public Client(String username){
        this.username = username;
    }

    @Override
    public void run() {
        try {
            socket = new Socket("localhost",9999);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            output.writeUTF(username);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String sender,String receiver,String msg){
        try {
            output.writeUTF(sender);
            output.writeUTF(receiver);
            output.writeUTF(msg);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void receiveMessage(){
        try {
            while (true) {                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
