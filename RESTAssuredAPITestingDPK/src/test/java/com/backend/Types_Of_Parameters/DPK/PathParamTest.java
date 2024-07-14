package com.backend.Types_Of_Parameters.DPK;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class PathParamTest {
	
	/* this class is created to showcase, to use pathParam)
	 * if we want to get any specific information we use this method
	 * It, also used for searching criteria, i.e select the resource based on one criteria*/
	
	/* pathParam() is used to set the resource path or end point in the URI, using
	 * pathParam(), we can execute same API with different parameter/values*/
	
	/* Advantage: Without changing the URI, we can execute same API request with different
	 * data*/
	
	@Test
	public void pathParameterTest() {
		
		baseURI = "http://49.249.28.218:8091";
		
		/*pre-condition*/
		given()
		.pathParam("projectId", "NH_PROJ_1202")
		
		/*http method*/
		.when()
		.get("/project/{projectId}")//No need to attach the path parameter in the URI
		
		/*response validation*/
		.then()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(3000L))
		.assertThat().body("projectName", Matchers.equalTo("TP_NinzaHRM_2371"))
		.log().all();
		
		
		
		
		
	}
	
}
