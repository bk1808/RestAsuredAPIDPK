package com.backend.ComplextPostRequest.DPK;

import org.testng.annotations.Test;

import com.backend.PojoClassLibUtility.DPK.ProjectPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostRequestViaPojoClass {

	@Test
	public void postDataToServer() {

		/* create an object of Random class from java.util package */
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		/* create an object of POJO class */
		ProjectPojo pojoobject = new ProjectPojo("Praveen", "ERP_" + ranNum, "Created", 10);

		/* pre-condition */
		given().contentType(ContentType.JSON).body(pojoobject)

				/* http method */
				.when().post("http://49.249.28.218:8091/addProject")

				/* response */
				.then().assertThat().statusCode(201).log().all();

	}

}
