package it.pale.tweb.dao.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class SecurityPassword {
	
	public static String sha512(String password) throws NoSuchAlgorithmException{
			//128 caratteri
		
	        MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
	        byte[] result = mDigest.digest(password.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for (byte b : result) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    }
}
