package com.backend.CRUDwithBDD.DPK;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutSampleTest {

	@Test
	public void putDataIntoServer() {

		JSONObject obj = new JSONObject();

		obj.put("createdBy", "Praveen");
		obj.put("projectName", "CRM_020");
		obj.put("status", "Created");
		obj.put("teamSize", 10);

		given()
		.contentType(ContentType.JSON)
		.body(obj.toJSONString())
		.pathParam("projectId", "NH_PROJ_249")
		
		.when()
		.patch("http://49.249.28.218:8091/project/{projectId}")
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
		
		
	}
}
