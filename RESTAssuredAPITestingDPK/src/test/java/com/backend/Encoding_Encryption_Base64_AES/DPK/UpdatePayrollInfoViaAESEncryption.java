package com.backend.Encoding_Encryption_Base64_AES.DPK;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class UpdatePayrollInfoViaAESEncryption {

	
	@Test
	public void updatePayrollInfoEncryption() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		baseURI = "http://49.249.28.218:8091";
		
		
		EncryptionAndDecryptionUtility ed = new EncryptionAndDecryptionUtility();
		
		String body = "{ \"employee\": { \"empId\":\"NH_0002\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"amdcd@gmail.com\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"2233665544\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 1, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active” }";
		
		String encryptBody = ed.encryptData(body, "Ac03tEam@j!tu_#1");
		System.out.println(encryptBody);
		
		/*pre-condition*/
		Response resp = given()
		.body(encryptBody)//the body payload is in the form of encrypted data
		
		/*http method execution*/
		.when()
		.put("/payroll");
		
		/*response validation*/
		resp.then().log().all();
		
		/*capturing the decrypted data*/
		String decryptedData = ed.decryptData(resp.getBody().asString(), "Ac03tEam@j!tu_#1");
		System.out.println(decryptedData);
		
		
	}
	
	
	
	
}
