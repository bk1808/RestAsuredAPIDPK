package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class CaptureMultipleDataFromResponse {

	@Test
	public void captureMultiData() {

		/* pre-condition */
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");

		/* http method */

		/* response */
		/*
		 * We cannot pass the RegEx in the jsonPath() method, hence we go for
		 * JSONPath.read() method ArrayList<String> list=
		 * response.jsonPath().get(".content[*].projectId"); System.out.println(list);
		 */
		
		response.then().log().all();
		ArrayList<String> idList = JsonPath.read(response.asString(), "$.content[*].projectId");

		for (String data : idList) {
			System.out.println(data);
		}
		
		ArrayList<String> projNameList = JsonPath.read(response.asString(), ".content[*].projectName");
		
		for(String projName:projNameList) {
			System.out.println(projName);
		}
	}

}
