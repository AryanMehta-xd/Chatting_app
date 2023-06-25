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
            socket = new Socket("192.168.0.102",9999);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            output.writeUTF(username);
            
            while (true) {                
                receiveMessage();
            }
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
            String sender_username = input.readUTF();
            String rev_username = input.readUTF();
            String msg = input.readUTF();
            
            if (msg.equals("user||disconnect")) {
                closeConnection();
                return;
            }
            
            callback.onMessageReceive(sender_username, rev_username, msg);
            
            System.out.println("Msg:"+msg+"\nfrom :"+sender_username);
        }catch (EOFException e) {
            System.out.println("Connection closed by the server.");
            closeConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeConnection(){
        try {
            if (socket != null && !socket.isClosed()) {
                output.writeUTF("!logout");
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
