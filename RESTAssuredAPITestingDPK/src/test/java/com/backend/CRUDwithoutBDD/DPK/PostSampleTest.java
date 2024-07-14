package com.backend.CRUDwithoutBDD.DPK;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostSampleTest {

	/*Before sending the request i need create a request body*/
	
	@Test
	public void postDataIntoServer() {
		/* create an JSON object of JSON simple to create a body/payload*/
		JSONObject obj=new JSONObject();
		
		/*the below data is in HashMap key value pair, so we need to convert this
		 * into JOSN format string before passing to body*/
		obj.put("createdBy", "Praveen");
		obj.put("projectName", "ERP_210");
		obj.put("status", "Created");
		obj.put("teamSize", 10);
		
		
	/* given() method will return the object of request specification Interface*/
	RequestSpecification request = given();
	
	request.contentType(ContentType.JSON);
	
	/*to create a payload of the request we need JSON-simple and we need to create
	 * JSON object, and convert the json object using toJSONString() method*/
	
	request.body(obj.toJSONString());
	/* All HTTP methods will return the object of Response Interface*/
	Response response = request.post("http://49.249.28.218:8091/addProject");
	response.then().log().all();
	response.then().assertThat().statusCode(201);
		
		
	}
	
}
