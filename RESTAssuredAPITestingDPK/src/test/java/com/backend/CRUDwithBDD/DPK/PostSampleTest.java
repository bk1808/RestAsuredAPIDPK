package com.backend.CRUDwithBDD.DPK;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostSampleTest {

	/*Before sending the request i need create a request body*/
	
	@Test
	public void postDataIntoServer() {
		JSONObject obj=new JSONObject();
		
		obj.put("createdBy", "Praveen");
		obj.put("projectName", "ERP_021");
		obj.put("status", "Created");
		obj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(obj.toJSONString())/*We are using toJSONString() method to convert
		or represent JSON object form to string form since
		RestAssured accepts the string representation of the JSON body*/
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	
		
		
	}
	
}
