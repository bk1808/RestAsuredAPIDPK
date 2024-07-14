package in.Backend.BasicRestAssured.requestBodyCreation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class RequestBodyAsHashmap {

	@Test
	public void createUser() {
		
		/*create a hashmap and store the body in key=value pair, with or without generic*/
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "praveen");
		data.put("job", "software tester");
		
		
		/*pre-condition*/
		given()
		.body(data)
		.contentType(ContentType.JSON)
		.log().all()
		
		/*http methods*/
		.when()
		.post("https://reqres.in/api/users")
	
		/*response*/
		.then()
		.log().all();
	
	
	}
	
	
	
}
