package com.backend.RequestChaining.DPK;

import org.testng.annotations.Test;

import com.backend.PojoClassLibUtility.DPK.EmployeePojo;
import com.backend.PojoClassLibUtility.DPK.ProjectPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Scenario2_AddEmployeeToProject {

	@Test
	public void addEmplyeeToProject() {

		/*
		 * Scenario-2: Add an employee to project by creating the project first, and
		 * using request chaining add an employee to the same project using projectId
		 */

		/* create an object of Random class from java.util package */
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		/*
		 * API-1 create a project first and capture projectId
		 */
		ProjectPojo pojoobject = new ProjectPojo("Praveen", "HRM_" + ranNum, "Created", 10);

		/* pre-condition */
		Response response = given().contentType(ContentType.JSON).body(pojoobject)

				/* http method */
				.when().post("http://49.249.28.218:8091/addProject");

		/* response */
		String projectName = response.jsonPath().get("projectName");

		response.then().log().all();

		/* API-2 add employee using projectId as end-point or path parameter */
		/* passing the projectName into the pojo class object */
		EmployeePojo createEmp = new EmployeePojo("Software Test Engineer",
				"10/06/1982", "abcd@gmail.com", "Robert" + ranNum, 5.5, "6633552552", projectName, "ROLE_EMPLOYEE",
				"Robert" + ranNum);
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(createEmp)
		
		/*http method*/
		.when()
		.post("http://49.249.28.218:8091/employees")
		
		/*response*/
		.then().assertThat().statusCode(201)
		.log().all();

	}

}
