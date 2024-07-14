package com.backend.AutherizationAndAuthentication.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreEmptiveAuthTest {

	/* pre-emptive auth is simple and it's neigther encoded not exncrypted but, 
	 * it's simple to use which doesn't require additional parsing by server*/
	
	@Test
	public void preEmptiveAuthorizationTest() {
		
		baseURI = "http://49.249.29.5:8091";
		
		/*pre-condition*/
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.log().all()
		
		
		/*http method execution*/
		.when()
		.get("/login")		
		
		
		/*response validation*/
		.then()
		.log().all();
		
	}
	
	
	
	
}
