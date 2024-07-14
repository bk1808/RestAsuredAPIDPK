package com.backend.ComplextPostRequest.DPK;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingHashmap {

	/* Approach-2: Posting the request to server by using HashMap of Java*/
	
	@Test
	public void postDataToServer() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("createdBy", "Praveen");
		map.put("projectName", "ERP_023");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		/*http method*/
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		/*response*/
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
	}
	
	
}
