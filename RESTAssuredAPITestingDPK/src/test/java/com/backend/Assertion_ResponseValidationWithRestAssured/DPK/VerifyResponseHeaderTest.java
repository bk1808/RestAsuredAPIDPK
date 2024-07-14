package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest {


	@Test
	public void verifyHeader() {
		
		
		/*pre-condition*/
		Response response = given()
		.get("http://49.249.28.218:8091/projects");//To capture the response we need to end the given() method for validation
		
		/*http method*/
		
		response.then().log().all();//using the response object we can validate the response header
		
		/*response*/
		response.then().assertThat().statusCode(200);//validate earch response using then() method
		response.then().assertThat().contentType(ContentType.JSON);
		response.then().assertThat().statusLine(Matchers.containsString("HTTP"));	
		response.then().assertThat().header("Transfer-Encoding", "chunked");
	
		
	}
	
	
}
