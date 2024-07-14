package com.backend.Encoding_Encryption_Base64_AES.DPK;

import java.util.Base64;

import org.testng.annotations.Test;


public class EncodeAndDecodeTest {

	
	@Test
	public void encodingTest() {
		
		
		
		/*Encoding*/
		String encodedData = new String(Base64.getEncoder().encode("TUSHAR".getBytes()));
		System.out.println(encodedData);
		
//		Encoded - O/P: QUJD
		
		/*Decoding*/
		String decodedData = new String(Base64.getDecoder().decode("VFVTSEFS".getBytes()));
		System.out.println(decodedData);
		
		/*Encoding and decoding the username and password*/
		
		String encodedCredentials = new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encodedCredentials);
		
//		Encoded - O/P: cm1neWFudHJhOnJtZ3lAOTk5OQ==
		
		String decodedCredentials = new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println(decodedCredentials);
		
	}
	
	
}
