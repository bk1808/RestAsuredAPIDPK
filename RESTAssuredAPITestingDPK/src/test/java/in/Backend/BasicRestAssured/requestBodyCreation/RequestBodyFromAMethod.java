package in.Backend.BasicRestAssured.requestBodyCreation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RequestBodyFromAMethod {

	
	@Test
	public void createUser() {
		/*pre-condition, this is the way to pass the request body using payload method from another class*/
		given()
		.header("Content-Type","application/json")//specify as 'Key,Value' pair, this is another way of using contentType() method we use this
		.body(PayLoad.createUser())
		.log().all()//to check what we are passing we use this
		
		/*http method*/
		.when()
		.post("https://reqres.in/api/users")
		
		/*response*/
		.then()
		.log().all();
	}
	
	
	
}
