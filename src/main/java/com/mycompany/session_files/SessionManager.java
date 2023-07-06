package com.mycompany.session_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import com.mycompany.dataPacks.data_encryption;

/**
 *
 * @author Aryan Mehta
 */
public class SessionManager {
    private static final String SESSION_FILE = "app_session.txt";
    
    
    public static void createSession(String username) {
        LocalDateTime startTime = LocalDateTime.now();
        String sessionData = data_encryption.encrypt(username) + "," + data_encryption.encrypt(startTime.toString());
        saveSessionData(sessionData);
    }
    
    private static LocalDateTime getSessionStartTime() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getSessionFilePath().toFile()))) {
            String sessionData = reader.readLine();
            if (sessionData != null && !sessionData.isEmpty()) {
                String[] parts = sessionData.split(",");
                String startTimeStr = data_encryption.decrypt(parts[1]);
                return LocalDateTime.parse(startTimeStr);
            }
        } catch (Exception e) {
            e.printStackTrace();       
        }
        return null;
    }
    
    public static boolean isSessionValid() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime sessionStartTime = getSessionStartTime();
        if (sessionStartTime != null) {
            //LocalDateTime expirationTime = sessionStartTime.plusMinutes(3); // Adjust expiration time as needed
            LocalDateTime expirationTime = sessionStartTime.plusDays(7);
            if (currentTime.isBefore(expirationTime)) {
                return true;
            } else {
                removeSession(); 
            }
        }
        return false;
    }
    
    private static void saveSessionData(String sessionData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getSessionFilePath().toFile()))) {
            writer.write(sessionData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static Path getSessionFilePath() {
        String userHomeDir = System.getProperty("user.home");
        return Paths.get(userHomeDir, SESSION_FILE);
    }
    
    public static void removeSession() {
        try {
            Files.deleteIfExists(getSessionFilePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getSessionUsername(){
        try (BufferedReader reader = new BufferedReader(new FileReader(getSessionFilePath().toFile()))) {
            String sessionData = reader.readLine();
            if (sessionData != null && !sessionData.isEmpty()) {
                String[] parts = sessionData.split(",");
                return data_encryption.decrypt(parts[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
} 
