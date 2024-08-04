package com.backend.Assertion_ResponseValidationWithRestAssured.DPK;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class MultipleWaysToValidateResponseTime {

	
	@Test
	public void waysToValidateResponseTime() {
		
		long expectedTime = 2000L;
		int expectedTimeSec = 2;
		
		
		Response response = given()
				.get("http://49.249.28.218:8091/projects");
		
		long timeTaken = response.time();//the time is in mili seconds
		long timeInSec = response.timeIn(TimeUnit.SECONDS);
		long getTime = response.getTime();
		
		
		
		
		
	}
	
	
	
}
