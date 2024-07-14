package com.backend.AutherizationAndAuthentication.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuthTest {

	/* in this class we are using the basic-digestiveAuth for login
	 * digestive auth is encoded and encrypted, encrypted using MD5-protocol[Message Digestive]*/
	
	@Test
	public void digestiveAuthTest() {
		
		baseURI = "http://49.249.29.5:8091";
		
		/*pre-condition*/
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.log().all()
		
		/*http method execution*/
		.when()
		.get("/login")
		
		/*response validation*/
		.then()
		.log().all();
		
	}
	
	
}
