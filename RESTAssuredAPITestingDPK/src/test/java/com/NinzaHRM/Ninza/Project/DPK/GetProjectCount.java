package com.NinzaHRM.Ninza.Project.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectCount {

	
	@Test
	public void getProjectsCount() {
		
		
		/* pre-condition*/
		given()
		.get("http://49.249.28.218:8091/count-projects")
		
		
		/* http method*/
		
		
		/* response validation*/
		.then().log().all();
		
	}
			
	
	
}
