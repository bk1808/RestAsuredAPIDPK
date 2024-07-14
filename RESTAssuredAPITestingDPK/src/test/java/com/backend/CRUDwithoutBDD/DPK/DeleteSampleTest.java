package com.backend.CRUDwithoutBDD.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DeleteSampleTest {

	/*this class is for delete() request and it doesn't require any pre-condition*/
	@Test
	public void deleteDataFromServer() {
		
		
		given();
		
		Response response = delete("http://49.249.28.218:8091/project/NH_PROJ_188");
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
