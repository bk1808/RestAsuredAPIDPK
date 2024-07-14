package in.Backend.BasicRestAssured.requestBodyCreation;

import org.testng.annotations.Test;

import pojo_classes_utility.CreateAUser;

import static io.restassured.RestAssured.*;

public class RequestBodyFromPOJOClass {

	@Test
	public void createUser() {
		
		/*to call the method of pojo class we need to create an object, and set all the 
		 * variables using the parameterized constructor*/
		
		CreateAUser userBody = new CreateAUser("praveen","test lead");
		
		/*pre-condition*/
		given()
		.body(userBody)
		.log().all()
		
		/*http method*/
		.when()
		.post("https://reqres.in/api/users")
		
		/*response*/
		.then()
		.log().all();
		
		
		
	}
	
	
}
