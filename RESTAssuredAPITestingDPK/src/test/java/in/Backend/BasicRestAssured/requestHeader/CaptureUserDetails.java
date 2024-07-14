package in.Backend.BasicRestAssured.requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CaptureUserDetails {

	/*In this class i have used Reqres http method
	 * multiple queries will be seperated using &ampersand*/

	@Test
	public void getUsersList() {
		
		/*pre-condition*/
		given()
		.queryParam("page", "2")//use the same key as your 'query' of swagger doc. it's case sensitive
		.queryParam("id", "12")
		.log().all()
		
		/*http method*/
		.when()
		.get("https://reqres.in/api/users")//the query parameter is passed here during the run-time
		
		/*response*/
		.then()
		.log().all();
		
	}
	
}
