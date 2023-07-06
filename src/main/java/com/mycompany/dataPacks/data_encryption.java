package com.mycompany.dataPacks;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.xerces.impl.dv.util.Base64;


/**
 *
 * @author Aryan Mehta
 */
public class data_encryption {
    
    private static final String ALGO = "AES";
    private static final byte[]ENC_KEY = "a1b2c3d4e5f6g7h8".getBytes();
    
    public static String encrypt(String plain_text){
        return text_encrypt(plain_text);
    }
    
    public static String decrypt(String cipher_text){
        return text_decrypt(cipher_text);
    }
    
    private static String text_encrypt(String plain_text){
        String cipher_text = null;
        
        try {
            Key key = new SecretKeySpec(ENC_KEY,ALGO);
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            
            byte[] encValue = cipher.doFinal(plain_text.getBytes());
            cipher_text = Base64.encode(encValue);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cipher_text;
    }
    
    private static String text_decrypt(String cipher_text){
        byte[] plain_text = new byte[0];
        
        try {
            Key key = new SecretKeySpec(ENC_KEY, ALGO);
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE,key);
            
            byte[] decValue = new Base64().decode(cipher_text);
            plain_text = cipher.doFinal(decValue);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(plain_text);
    }
}
