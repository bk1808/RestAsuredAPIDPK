package com.backend.Encoding_Encryption_Base64_AES.DPK;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;

public class AESEncryptionTest {

	/*AES - Symmitric encryption, we use same private in both client and */
	@Test
	public void aesEncryptionTest() throws Throwable, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, Throwable {
		
		
		String privateKey = "Ac03tEam@j!tu_#1";
//		String data = "Praveen";
		String data = "{\"name\":\"praveen\",\"id\":\"tp_1\"}";
		
		
		EncryptionAndDecryptionUtility edUtil = new EncryptionAndDecryptionUtility();
//		edUtil.encryptData(data, privateKey);
//		edUtil.decryptData(data, privateKey);    
		System.out.println(edUtil.encryptData(data, privateKey));
//		System.out.println(edUtil.decryptData("ICC4IuBC69m9yt4V4nog3g==", privateKey));
		System.out.println(edUtil.decryptData("Xv1tH4ehjUaZIcFJ/k1ER8Tqn51+ydC0qiIxeqeLrbk=", privateKey));
	
		
		
		
		
		
	}
	
}
