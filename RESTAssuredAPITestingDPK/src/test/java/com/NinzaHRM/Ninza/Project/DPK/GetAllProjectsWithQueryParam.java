package com.NinzaHRM.Ninza.Project.DPK;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectsWithQueryParam {

	
	@Test
	public void getAllProjects() {
	
	/* pre-condition*/
	given()
	

	/*http method*/
	.when()
	.post("http://49.249.28.218:8091/getAll?query=string")
	
	
	
	/*response*/
	
	.then().assertThat().statusCode(200)
	.assertThat().statusLine(Matchers.containsString("HTTP"))
	.assertThat().body("data", Matchers.equalTo(null))
	.assertThat().body("errors[0].locations[0].line", Matchers.equalTo(1))
	.log().all();
	
	}
	
}
