package com.backend.ComplextPostRequest.DPK;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestViaJSONobject {

	/* Approach-1: POST request using JSON object
	 * For this approach json-simple dependency is necessary*/
	@Test
	public void postRequestToServer() {
		JSONObject obj=new JSONObject();
		
		obj.put("createdBy", "Praveen");
		obj.put("projectName", "ERP_025");
		obj.put("status", "Created");
		obj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(obj.toJSONString())
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	
		
	}
	
	
}
