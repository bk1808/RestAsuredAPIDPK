package in.Backend.BasicRestAssured.reqresResponseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CaptureUsersInfo {

	@Test
	public void CaptureUsers() {

		/*Must validate[ mandatory] things in API request:
		 * 1. status Code
		 * 2. status Message
		 * 3. response Time
		 *  */
		
		/*pre-condition*/
		given()
		
		
		/*http method*/
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		/*response*/
		.then()
		.assertThat()
		.statusCode(200)/*it accepts the argument status code as integer, if there's a 
		mismatch in the status code the assertion will fail*/
		.statusLine(containsString("OK"))/*to verify the status line of the status code which is a string data
		we use this method, but response status will contain "HTTP/1.1 200 OK" hence
		we need to use*/
		.time(lessThanOrEqualTo(5000l))/*we need to specify the time value as LONG else it'll show error
		because, time methods takes the argument as LONG hence, specify the 'L/l' at the end of time*/
		.header("Server", equalTo("cloudflare"))/*use equalTo() method present in 'Matchers' class and specity
		the key and value to match the header content.The common data that'll verified in the header section is
		server' information */
		.header("Content-Type", containsString("application/json"))
		.body("page", equalTo(2))
		.body("data[0].first_name", equalTo("Michael"))/*we need to provide the JSON path in
		place of value*/
		.log().all();
		
	
	}

}