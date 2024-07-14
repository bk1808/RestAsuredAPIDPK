package com.backend.CRUDwithoutBDD.DPK;

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

		obj.put("projectName", "ERP_255");

		RequestSpecification request = given();
		request.contentType(ContentType.JSON); 

		request.body(obj.toJSONString());//converting JSON object to JSON file format
	
		Response response = request.patch("http://49.249.28.218:8091/project/NH_PROJ_608");
		response.then().log().all();
		response.then().assertThat().statusCode(200);

	}
}
