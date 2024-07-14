package in.Backend.BasicRestAssured.requestBodyCreation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class RequestBodyFromJSONFile {


	@Test
	public void createUser() {
		
		/*For importing the JSON file from src/test/resources we need to
		 * create File object of Java.io package*/
		
		/*File jsonFile = new File("./src/test/resources/createUser.json");
		either we pass the reference of file object or we can create a file object inside
		the request body itself*/
		
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(new File("./data/createUser.json"))
		.log().all()
		
		/*http method*/
		.when()
		.post("https://reqres.in/api/users")
		
		/*response*/
		.then()
		.log().all();
	}
	
	
}
