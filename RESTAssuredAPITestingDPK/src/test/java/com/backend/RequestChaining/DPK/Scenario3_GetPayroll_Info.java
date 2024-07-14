package com.backend.RequestChaining.DPK;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario3_GetPayroll_Info {

	
	@Test
	public void getEmpPayRollInfo() {
		
		/*In order to get the payroll information from the server developer has 
		 * given one authentication protocol i.e. Oauth2 protocol which will have
		 * certain details to get the payroll information, first user has to hit
		 * authentication protocol first, before hitting th protocol, pass
		 * the information related to Oauth2 provided by developer in the 
		 * .formParam(), such as client_id, client_secret, grant_type & redirectURL:
		 * > client_id: ninza-client
		 * > client_secret: It will be generated [get it and store it in variable]
		 * > grant_type : client_credentials
		 * > redirectURL (post) http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token
		 * you pass this informtion, the authentication protocol will check whether you
		 * are a valid user or not by using the above info, it will generate token if you
		 * are a valid user, you need to pass that token first
		 * inside the login before getting the payroll info*/
		
		/*pre-condition: API-1 login to applicaion and get authentication protocol info*/
		Response response = given()
		.formParam("client_id","ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		
		/*http method, this method will generate the token
		 * In this method the status code of post is 200 not 201
		 * because we cannot pass the body in get method and with this psost we are not creating anything*/
		
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		
		/*response: capture the access_token from the response*/
		String token = response.jsonPath().get("access_token");
		response.then().log().all();
		
		/*pre-condition: API-2 get the payroll information by using token*/
		given()
		.auth().oauth2(token)
		.get("http://49.249.28.218:8091/admin/payrolls")
		
		/*http method*/
		
		/*response*/
		.then().log().all();
		
		
		
	}
	
	
	
}
