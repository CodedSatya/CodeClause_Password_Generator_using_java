package generator;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import security.Encrypter;

import java.util.*;

public class Generator {
	private static String generate() {
		String password = "" ;
		
		String LOWER_CASE = "qwertyuiopasdfghjklzxcvbnm";
		String UPPER_CASE = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String SYMBOLS    = "~`! @#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
		
		int length = 8 + (int)(Math.random()*8);
				
		for(int i=0;i<length;i++) {
			
			int n = (int) (Math.random()*3);
			
			switch(n) {
			 case 0 :
				 password += LOWER_CASE.charAt((int)(Math.random()*LOWER_CASE.length()));break;				 
			 case 1 :
				 password += UPPER_CASE.charAt((int)(Math.random()*UPPER_CASE.length()));break;
			 case 2 :
				 password += SYMBOLS.charAt((int)(Math.random()*SYMBOLS.length()));break;
			}
		}
	
		return password;
	}
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Password for : ");
		String passFor = sc.nextLine(); 
		
		String path ="C:\\Users\\satya\\OneDrive\\Desktop\\PasswordGenerator\\PasswordGenerator\\Password\\"+passFor+"_Password.txt";
		
		String pass = generate();
		System.out.println("Password : "+pass);
		Encrypter en = new Encrypter();

		
		en.encrypt(pass,path);
		
		
		
		
	}
}

