package com.NinzaHRM.Ninza.Project.DPK;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninzahrm.api.baseutility.BaseAPIClass;
import com.ninzahrm.api.constants.endpoint.IEndpoint;

import io.restassured.response.Response;
import pojo_classes_utility.ProjectPojo;

public class ProjectTest extends BaseAPIClass {

	
	@Test
	public void addSingleProjectWithCreatedTest() throws Throwable {

	
		String baseUri = fLib.getDataFromPropertiesFile("baseuri");

		int ranDm = jLib.getRandomNumber();
		
		String expectedMsg = "Successfully Added";
		String projName = "TP_NinzaHRM_" + ranDm;

		/* verify the project name in API layer */

		pojoObj = new ProjectPojo("Praveen", projName, "Created", 21);

		/* pre-condition */
		Response response = (Response) given()
				.spec(reqSpecObj)
				.body(pojoObj)
				.log().all()
				/* http method */
				.when().post(IEndpoint.ADD_PROJ);				

		/* response validation */
		response.then().assertThat().statusCode(201);
		response.then().time(Matchers.lessThan(3000L));
		response.then().spec(resSpecObj);
//		response.then().assertThat().body("msg", Matchers.equalTo("Successfully Added"));
		response.then().log().all();
		String actualMsg = response.jsonPath().get("msg");
		Assert.assertEquals(actualMsg, expectedMsg);

		/*
		 * verify the project name in DB using RDP [remote desktop connection]- put a
		 * validation for DB as per the rule
		 */

		
		dLib.getDBConnection(baseUri, projName, actualMsg);
		boolean flag = dLib.executeQueryVerifyAndGetData("select * from project", 4, projName);
		
		Assert.assertTrue(flag, "project in DB is not verified");
				
	}

	@Test(dependsOnMethods = "addSingleProjectWithCreatedTest")
	public void createDuplicateProjectTest() throws IOException {

//		String baseUri = fLib.getDataFromPropertiesFile("baseuri");

		/* pre-condition */
		given()
		.spec(reqSpecObj)
		.body(pojoObj)

				/* http method */
				.when().post(IEndpoint.ADD_PROJ)

				/* response validation */
				.then()
				.spec(resSpecObj)
				.assertThat().statusCode(409)

				.log().all();

	}
	
}
