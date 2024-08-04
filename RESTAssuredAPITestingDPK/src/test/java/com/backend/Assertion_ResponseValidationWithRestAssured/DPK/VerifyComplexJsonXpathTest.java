package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;



public class VerifyComplexJsonXpathTest {

	@Test
	public void sampleTest() {
		
		String expectedProjID="NH_PROJ_877";
		/*pre-condition*/
		Response response = given()
		.get("http://49.249.28.218:8091/projects-paginated");
		
		
		/*http method*/
		
		
		/*response*/
		response.then().log().all();
		
		/*to use the below method we need to install Json-path dependancy by Jayway on MVN repository*/
		
		ArrayList<String> list = JsonPath.read(response.asString(),".content[*].[?(@.projectName=='tekpyramid787')].projectId");		
		
		String actProjId="";
		for(int i=0 ; i<list.size() ; i++) {
			
			actProjId = list.get(i);
			 
		}
		
		
		/* After extracting the data from RestAssured we need to go for testNG assertion*/
		Assert.assertEquals(actProjId, expectedProjID);
		
		/* After extracting the data projectId we can go for DB validation, create the
		 * the project and get the data dynamically in the for loop for validation */
	
	}
	
}
