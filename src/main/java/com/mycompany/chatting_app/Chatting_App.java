package com.mycompany.chatting_app;

import com.mycompany.resources.*;
import com.mycompany.session_files.SessionManager;

public class Chatting_App {
    public static void main(String[] args) {
        if (SessionManager.isSessionValid()) {
            new main_page(SessionManager.getSessionUsername());
        }else{
            new login_page();
        }
    }
}
