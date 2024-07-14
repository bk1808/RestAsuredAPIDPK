package in.Backend.BasicRestAssured.reqresCRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CaptureUsersInfo {

	@Test 
	public void getUsersList() {
		
		/*pre-condition*/
		
		RestAssured.given()
		/*for get method we do not specify anything in the given or pre-condition method*/
		
		
		/*http methods*/
		
		.when()
		.get("https://reqres.in/api/users?page=2")// you can also check for page#1
		
		/*response*/
	
		.then()
		.log().all();
		
		
	}
	
	
}
