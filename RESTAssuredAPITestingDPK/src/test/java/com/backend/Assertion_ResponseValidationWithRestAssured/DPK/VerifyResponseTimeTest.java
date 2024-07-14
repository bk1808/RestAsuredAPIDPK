package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {

	@Test
	public void verifyHeader() {
		
		/*pre-condition*/
		Response response = given()
		.get("http://49.249.28.218:8091/projects");
		
		/*http method*/
		
		
		/*methods to capture response time*/
		long timeTaken = response.time();//the time is in mili seconds
		long timeInSec = response.timeIn(TimeUnit.SECONDS);
		long getTime = response.getTime();
		
		System.out.println(timeTaken);
		System.out.println(timeInSec);
		System.out.println(getTime);
		
		/* time validation expected vs actual less than the set time*/
		response.then().time(Matchers.lessThan(5000L));//Mili second always will be in Long form
		
		/* time validation expected vs actual more than the set time*/
		response.then().time(Matchers.greaterThan(3000L));
		
		/* time validation [condition] within the time set both less than and greaterthan using .and method*/
		response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(3000L)));
		
		
	}
	
}
