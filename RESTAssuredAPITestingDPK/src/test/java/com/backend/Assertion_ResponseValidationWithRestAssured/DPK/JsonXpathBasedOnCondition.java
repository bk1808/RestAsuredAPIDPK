package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;



public class JsonXpathBasedOnCondition {

	@Test
	public void getJsonXpathForCondition() {
	
		String expectedProjId = "NH_PROJ_996";
		
		/*pre-condition*/
		Response response = given()
		.get("http://49.249.28.218:8091/projects-paginated");
		
		/*http method*/
		/*response*/
		response.then().log().all();
		List<String> list = JsonPath.read(response.asString(), "$.content[*].[?(@.projectName=='Dietrich LLC')].projectId");
		
		String actualProjId = "";
		
		for(int i = 0 ; i<list.size() ; i++) {
			
			actualProjId = list.get(i);
		}
		
		/* this is testNG assertion, we cannot go for RestAssured assertion, we need to 
		 * extract the data and use testNG assertion*/
		
		Assert.assertEquals(actualProjId, expectedProjId);
	}	
}
