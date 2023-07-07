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
    private static final byte[]AES_ENC_KEY = "a1b2c3d4e5f6g7h8".getBytes();
    
    private static final int ceaser_KEY = 21;
    
    
    //CEASER->AES
    public static String encrypt(String plain_text){
        return text_encrypt(ceaser_encrypt(plain_text));
    }
    
    //AES->CEASER
    public static String decrypt(String cipher_text){
        return ceaser_decrypt(text_decrypt(cipher_text));
    }
    
    private static String text_encrypt(String plain_text){
        String cipher_text = null;
        
        try {
            Key key = new SecretKeySpec(AES_ENC_KEY,ALGO);
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
            Key key = new SecretKeySpec(AES_ENC_KEY, ALGO);
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE,key);
            
            byte[] decValue = new Base64().decode(cipher_text);
            plain_text = cipher.doFinal(decValue);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(plain_text);
    }
    
    private static String ceaser_encrypt(String plain_text){
        StringBuilder cipher_text = new StringBuilder();
        
        for(int i=0;i<plain_text.length();i++){
            char ch = plain_text.charAt(i);
            if(Character.isLetter(ch)){
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char shiftedChar = (char) (((ch - base + ceaser_KEY) % 26) + base);
                cipher_text.append(shiftedChar);
            }else{
                cipher_text.append(ch);
            }
        }
        return cipher_text.toString();
    }
    
    private static String ceaser_decrypt(String cipher_text){
        StringBuilder plain_text = new StringBuilder();
        
        for(int i=0;i<cipher_text.length();i++){
            char ch = cipher_text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char shiftedChar = (char) (((ch - base - ceaser_KEY + 26) % 26) + base);
                plain_text.append(shiftedChar);
            } else {
                plain_text.append(ch);
            }
        }
        return plain_text.toString();
    }
}
