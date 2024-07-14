package com.backend.practice.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DemoUsingMethodChainingTest {

	/*this class is an example of method chaining*/
	@Test
	public void getRequestTest() {
		
		get("https://reqres.in/api/users?page=2").then().log().all();
		/*prettyPrint() method will return only response paylod wherein
		 * log.all() will return the complete log information along with response*/
		
	}
	
	
}
