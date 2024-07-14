package in.Backend.BasicRestAssured.requestBodyCreation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUser {

	@Test
	public void createAUser() {
		
		/*pre-condition*/
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		/*http method*/
		.when()
		.post("https://reqres.in/api/users")
		
		/*reponse*/
		.then()
		.log().all();
		
		
	}
	
}
