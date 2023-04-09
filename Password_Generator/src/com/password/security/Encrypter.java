package com.password.security;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Encrypter {
	public static KeyPair KP;
	public static void encrypt (String pass,String path) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		
		Signature sign = Signature.getInstance("SHA256withRSA");
		
		KeyPairGenerator KPG = KeyPairGenerator.getInstance("RSA");
		
		KPG.initialize(516);
		KP = KPG.generateKeyPair();
		
		
		
		PublicKey PublicK = KP.getPublic();
		
		System.out.println("Key generated...");
		
		Cipher ciph = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		ciph.init(Cipher.ENCRYPT_MODE, PublicK);
		
		byte[] epass = pass.getBytes();
		ciph.update(epass);
		
		byte[] CipherText = ciph.doFinal();
		
		String encryptpass = new String(CipherText , "UTF8");
		
		System.out.println("Encryption Done..."); 
		
		File newFile = new File(path);
		FileWriter filew = new FileWriter(newFile);
		
		filew.write(encryptpass);
		filew.close();
		
		System.out.println("Encrypted key password saved...");
		
		System.out.println("Password Encrypted");
		
		System.out.println("Check "+path);
		
	}
}
