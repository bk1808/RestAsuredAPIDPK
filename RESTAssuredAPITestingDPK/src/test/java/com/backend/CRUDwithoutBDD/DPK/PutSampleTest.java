package com.backend.CRUDwithoutBDD.DPK;

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
		obj.put("projectName", "ERP_125");
		obj.put("status", "Created");
		obj.put("teamSize", 10);

		RequestSpecification request = given().pathParam("projectId", "NH_PROJ_608");
		request.contentType(ContentType.JSON); 

		request.body(obj.toJSONString());

		Response response = request.put("http://49.249.28.218:8091/project/{projectId}");
		response.then().log().all();
		response.then().assertThat().statusCode(200);

	}
}
