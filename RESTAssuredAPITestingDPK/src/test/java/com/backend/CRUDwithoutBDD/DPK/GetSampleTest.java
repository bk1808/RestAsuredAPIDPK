package com.backend.CRUDwithoutBDD.DPK;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSampleTest {

	
	@Test
	public void getDataFromServer() {
		
		Response response = RestAssured.get("http://49.249.28.218:8091/projects");
//		response.prettyPrint();
//		response.asString();
//		response.body();
		
//		System.out.println(response.prettyPrint());//this method will format the response into JSON format {withing braces as paragraph}
//		System.out.println(response.asString());
//		System.out.println(response.body());
//		response.then().assertThat().statusCode(200);
		response.then().log().all();
		
	}
	
	
	
}
