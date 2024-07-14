package com.backend.Types_Of_Parameters.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParamTest {

	/* we created this class to capture a specific project details based on projectId
	 * out of a list of projects, we go for query parameter*/
	/* It always in the form of key value pair followed by '?'. It's always present
	 * at the end of the URI. It's used to search and filter the resource via API*/
	
	/* Advantage: Without changing the URI, we can execute same API request with
	 * different filter or search data*/
	
	@Test
	public void queryParameterTest() {
		
		baseURI = "http://49.249.28.218:8091";
		
		/*pre-condition*/
		given()
//		.queryParam("projectId", "NH_PROJ_1202")
		.queryParam("teamSize", 10)
		
		/*http method*/
		.when()
//		.get("/project?projectId=NH_PROJ_1202")//to search and to filter the condition
//		.get("/project?teamSize=10")//it's the example of filtering the data of project which consists of team size 10
		.get("/project")//need not mention the query paramter along with end-point if we use queryParam() method
		
		/*response validation*/
		.then()
		.log().all();
		
		
		
	}
	
}
