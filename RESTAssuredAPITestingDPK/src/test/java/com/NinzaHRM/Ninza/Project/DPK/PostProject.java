package com.NinzaHRM.Ninza.Project.DPK;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.backend.PojoClassLibUtility.DPK.ProjectPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostProject {

	@Test
	public void createNewProject() {
		
		Random random = new Random();
		int ranDm = random.nextInt(3000);
		
		ProjectPojo pojoObj = new ProjectPojo("Praveen", "TP_NinzaHRM_"+ranDm, "Created", 21);
		
		/*pre-condition*/
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pojoObj)
		
		
		/*http method*/
		.when()
		.post("http://49.249.28.218:8091/addProject");
		
		/*response validation*/
		response.then().assertThat().statusCode(201);
		response.then().assertThat().body("msg", Matchers.equalTo("Successfully Added"));
		String projId = response.jsonPath().get("projectId");
		response.then().log().all();
		System.out.println(projId);
		
		
		
	}
	
	
	
}
