package com.backend.JSONSchemaValidaiton;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {

	
	@Test
	public void jsonSchemaValidationTest() {
		
		String body = "{\r\n"
				+ "  \"createdBy\": \"Praveen\",\r\n"
				+ "  \"projectName\": \"NH_008\",\r\n"
				+ "  \"status\": \"Created\",\r\n"
				+ "  \"teamSize\": 10\r\n"
				+ "}";
		
		baseURI = "http://49.249.28.218:8091";
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(body)
		
		/*http method execution*/
		.when() 
		.post("/addProject")
		
		/*response validation*/
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchema(body))
		.assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("./configEnvData/schemavalidation.json")))
		.log().all();
		
		
	}
	
	
}
