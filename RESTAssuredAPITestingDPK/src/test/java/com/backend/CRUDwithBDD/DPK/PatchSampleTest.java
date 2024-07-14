package com.backend.CRUDwithBDD.DPK;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchSampleTest {

	@Test
	public void patchDataIntoServer() {

		/* this class is used for partial update i.e. PATCH()*/
		JSONObject obj = new JSONObject();

		obj.put("projectName", "SCM_010");

		given()
		.contentType(ContentType.JSON)
		.pathParam("id", "NH_PROJ_249")
		.body(obj.toJSONString())
		
		.when()
		.patch("http://49.249.28.218:8091/project/{id}")

		.then()
		.assertThat().statusCode(200)
		.log().all();


	}
}
