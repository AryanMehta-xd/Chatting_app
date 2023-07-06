package com.mycompany.dataPacks;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;

public class Client extends Thread{
    private String username;
    private DataOutputStream output;
    private DataInputStream input;
    private Socket socket;
    private MessageReceivedCallbacbk callback;
    
    public Client(String user,MessageReceivedCallbacbk callB){
        this.username = user;
        this.callback = callB;
    }

    @Override
    public void run() {
        try {
            socket = new Socket("192.168.0.135",9999);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            output.writeUTF(username);
            
            boolean isOnline = true;
            
            while (isOnline) {                
                isOnline = receiveMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String sender,String receiver,String msg,String time){
        try {
            output.writeUTF("!sendMessage");
            output.writeUTF(sender);
            output.writeUTF(receiver);
            output.writeUTF(msg);
            output.writeUTF(time);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean receiveMessage(){
        try {
            String sender_username = input.readUTF();
            String rev_username = input.readUTF();
            String msg = input.readUTF();
            String msg_time = input.readUTF();

            callback.onMessageReceive(sender_username, rev_username, msg,msg_time);
            
            //System.out.println("Msg:"+msg+"\nfrom :"+sender_username+"\nOn :"+msg_time);
        }catch (EOFException e) {
            System.out.println("Connection closed by the server.");
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void userLogout(){
        try {
            if (socket != null && !socket.isClosed()) {
                output.writeUTF("!logout");
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void userDisconnect(){
        try {
            if (socket != null && !socket.isClosed()) {
                output.writeUTF("!userdisconnect");
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
