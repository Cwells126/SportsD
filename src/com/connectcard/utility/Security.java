package com.connectcard.utility;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;




	public class Security {  
	    private Cipher ecipher;  
	    private Cipher dcipher;  
	    
	  
	    public Security(String keyString) {  
	        try {  
	            SecretKey key = new SecretKeySpec(keyString.getBytes(), "AES");
	            ecipher = Cipher.getInstance("AES");  
	            dcipher = Cipher.getInstance("AES");  
	            ecipher.init(Cipher.ENCRYPT_MODE, key);  
	            dcipher.init(Cipher.DECRYPT_MODE, key);  
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	        }  
	    } 
	    
	    
	    
	    /**
	     * Generates a random DES-encrypted key
	     * @return the randomly generated key
	     */
	    public static String generateKey(){
	        SecureRandom random = new SecureRandom();
	        KeyGenerator keygen = null;
	        try {
	        	// get the key generator and seed it with a random long
	            keygen = KeyGenerator.getInstance("DESede");
	            keygen.init(random);
	        } catch (NoSuchAlgorithmException ex) {
	            ex.printStackTrace();
	        }
	        
	        // get the key and return it as a Base64-encoded string
	        Key key = keygen.generateKey();
	        return Base64.encodeBase64String(key.getEncoded());
	    }
	    
		     
	  
	    /**
	     * encrypts the passed-in string using the ciphers created during object construction
	     * @param str the string to encrypt
	     * @return the AES-encrypted for of the passed-in string
	     */
	    public String encrypt(String str) {  
	        try {  
	        	// get the encoded bytes and encrypt the bytes
	            byte[] utf8 = str.getBytes("UTF-8");  
	            byte[] enc = ecipher.doFinal(utf8);  
	            
	            // return encrypted bytes as string
	            return Base64.encodeBase64String(enc);  
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	        }  
	        return null;  
	    }  
	    
	    
	    
	    /**
	     * decrypts the passed in string using the ciphers created during object construction
	     * @param str the string to decrypt
	     * @return the decrypted string
	     */
	    public String decrypt(String str) {  
	        try {  
	        	// get the encoded bytes and decrypt the bytes
	            byte[] dec = Base64.decodeBase64(str);
	            byte[] utf8 = dcipher.doFinal(dec);  
	  
	            // return decrypted bytes as string
	            return new String(utf8, "UTF-8");  
	        } catch (Exception e) {  
	            e.printStackTrace();
	        }  
	        return null;  
	    }
}
