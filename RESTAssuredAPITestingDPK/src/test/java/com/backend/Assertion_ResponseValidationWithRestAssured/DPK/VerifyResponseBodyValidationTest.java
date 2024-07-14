package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class VerifyResponseBodyValidationTest {

	/* Verify the response body using JSON path */

	@Test
	public void responseBodyValidation() {

		/* pre-condition */
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");

		/* http method */

		/*
		 * response [whenever we are using jsonpath method we need not write dot(.)] if
		 * we capture the data and want to validate then, we need to go for testNG
		 * assertion hence, we go for RestAssured inbuild assertThat() method for
		 * validation
		 */
		
		  response.then().log().all(); int data1 =
		  response.jsonPath().get("numberOfElements"); System.out.println(data1);
		  boolean data2 = response.jsonPath().get("pageable.sort.unsorted");
		  System.out.println(data2); String data3 =
		  response.body().jsonPath().get("content[0].projectId");
		  System.out.println(data3);
		  
		  response.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
		 
		  response.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		 
		  List<String>list = response.jsonPath().get("content.projectId");
		  
		  for(String data:list) {
			  System.out.println(data);
		  }
		
		/* If we want to validate the static pro*/
//		response.then().assertThat().body("content[0].projectId", Matchers.equalTo(data3));

	}

}
