package in.Backend.BasicRestAssured.reqresResponseValidation;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CatureResponse {

	/* this class is an example of request chaining or method chaining */

	@Test
	public void getUsersList() {
//		Expected Data
		int expectedStatusCode = 200;
		String expectedStatusMessage = "OK";
		long expectedResponseTime = 5000L;

		/* pre-condition */
		Response response = given()/*
									 * to capture the response we use the Response interface present in
									 * io.restassured package
									 */

				/* http method */
				.when()
				.get("https://reqres.in/api/users?page=2");/*
															 * the http methods will return the Response type object
															 */

		/*the below for loop is to capture the data irrespective of the JSON path where that data is located*/
		String emailId = "";
		int numberOfUsers = response.jsonPath().getList("data").size();
		for (int i = 0; i < numberOfUsers; i++) {

			String username = response.jsonPath().getString("data[" + i + "].first_name");
			if (username.equals("Michael")) {
				emailId = response.jsonPath().getString("data[" + i + "].email");
				break;// as soon as you find the emailId of the person stop the iteration
			}

		}
		System.out.println(emailId);
		/* approach-1 validating using inbuilt rest assured library methods */
		response.then().assertThat()// by using the response ojbect we will validate the data
				.statusCode(200).statusLine(containsString("OK"));
		System.out.println("Total number of users: " + response.jsonPath().getList("data")
				.size());/*
							 * this will provide the list having number of objects present in the data array
							 * of response body and it will give the number
							 */

		/*
		 * appraoch-2 capturing the values from the response to validate using testNG
		 * assertion
		 */
		int actualStatus = response.getStatusCode();
		Assert.assertEquals(actualStatus, expectedStatusCode, "status code is not matching");

		/* We can use other methods present in Response class to validate
		String actualStatusMessage = response.getStatusLine();
		Assert.assertEquals(actualStatusMessage, expectedStatusMessage, "status message is not matching");

		long actualResponseTime = response.time();
		Assert.assertEquals(actualResponseTime, expectedResponseTime, "response time is not matching");
		response.header("application/json");
		response.getBody().jsonPath().get();*/
	}

}
