package com.backend.AutherizationAndAuthentication.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {

	/* NizaPay application is developed using Oauth-Open Authorization
	 * > In basic auth, username and password is encoded. 
	 * Ex: Headers: Accept=**
	 * URL for NinzaPay: http://49.249.29.5:8091/*/
	
	@Test
	public void basicAuthorizationTest() {
		
		baseURI = "http://49.249.29.5:8091";
//		basePath = "/login";//this provides the entire HTML source code of the resource path 
				
		/*pre-condition*/
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.log().all()
		
		/*http method execution*/
		.when()
		.get("/login")
		
		/*response validation*/
		.then()
		.log().all();
		
	}
	
	
}
