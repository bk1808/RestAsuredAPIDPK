package com.backend.CRUDwithBDD.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteSampleTest {

	/*this class is for delete() request and it doesn't require any pre-condition*/
	@Test
	public void deleteDataFromServer() {
		
		
		
		given()
		.pathParam("projectId", "NH_PROJ_249")
		.delete("http://49.249.28.218:8091/project/{projectId}")
		
		.then()
		.assertThat().statusCode(204)
		.log().all();
		

	}
	
	
	
}
