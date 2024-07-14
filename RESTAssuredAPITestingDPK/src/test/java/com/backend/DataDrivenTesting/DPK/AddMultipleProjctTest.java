package com.backend.DataDrivenTesting.DPK;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjctTest {

	/* request body can be created using POJO class, hashmap, or string array*/
	
	@Test (dataProvider = "getData")
	public void multipleProjectTest(String projectName, String status) {
		
		baseURI = "http://49.249.28.218:8091";
				
//		String projectName ="Rakuten";
//		String status = "Created";
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Praveen\",\r\n"
				+ "  \"projectName\": \""+projectName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 10\r\n"
				+ "}";
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(reqBody)
				
		/*http method execution*/
		.when()
		.post("/addProject")
		
		
		/*response validation*/
		.then()
		.log().all();
		
		
	}
	
	@DataProvider 
	public Object[][] getData() {
		
		Object [] [] objArr = new Object [3] [2];
		
		objArr [0] [0] = "Emirates_01";
		objArr [0][1] = "Created";
		
		objArr [1][0] = "Emirates_02";
		objArr [1][1] = "Created";
		
		objArr [2][0] = "Emirates_03";
		objArr [2][1] = "Created";
		
		return objArr;
		
	}
	
	
	
}
