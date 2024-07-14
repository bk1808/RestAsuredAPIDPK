package com.backend.RequestChaining.DPK;

import org.testng.annotations.Test;

import com.backend.PojoClassLibUtility.DPK.ProjectPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Scenario1_DeleteProject {

	@Test
	public void deleteProjectInServer() {

		/*
		 * Scenario-1: Create a project and delete project by passing the data
		 * dynamically using request chaining concept using projectId as variable in the
		 * end-point
		 */

		/* create an object of Random class from java.util package */
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		/*
		 * API-1 request to add Project: create an object of POJO class, execute API-1
		 * request to addd
		 */
		ProjectPojo pojoobject = new ProjectPojo("Praveen", "HRM_" + ranNum, "Created", 10);

		/* pre-condition */
		Response response = given().contentType(ContentType.JSON).body(pojoobject)

				/* http method */
				.when().post("http://49.249.28.218:8091/addProject");

		/* response */
		response.then().log().all();

		/* capture project name from the response */
		String projectId = response.jsonPath().get("projectId");

		/* API-2 delete project using the request chaining - projectId */

		given().delete("http://49.249.28.218:8091/project/" + projectId).then().log().all();

	}

}
