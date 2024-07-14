package com.backend.Encoding_Encryption_Base64_AES.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APIEncodingTest {

	@Test
	public void restAssuredEncodingTest() {
		
		baseURI = "http://49.249.29.5:8091";
		
		/*pre-condition*/
		given()
//		.auth().basic("rmgyantra", "rmgy@9999")
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		
		/*http method execution*/
		.when()
		.get("/projects")
		
		/*response validation*/
		.then()
		.log().all();
		
	}
	
	
	
	
	
}
