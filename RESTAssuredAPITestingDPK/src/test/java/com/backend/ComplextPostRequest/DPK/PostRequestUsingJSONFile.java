package com.backend.ComplextPostRequest.DPK;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingJSONFile {

	/* Appraoch-3: By using the JSON file we can post request or pass the data
	 * Since, i have added Jackson dependency the file will automatically parsed
	 * 1. Pass the source/path of the JSON file along with data into .body() method  
	 * 2. But, with this approach the post request will fail for the second time due to
	 * duplicate data or project name which need to be created dynamically. Hence, we go for POJO class
	 * */
	
	@Test
	public void postDataToServer() {
				
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(new File("./src/test/resources/project.json"))
		
		/*http method*/
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		/*response*/
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
		
	}
}
