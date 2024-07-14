package in.Backend.BasicRestAssured.reqresCRUD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUser {

	@Test
	public void deleteAUser() {
		
		/*pre-condition*/
		given()
		/*we need not have to pass anything here*/
		
		/*http method*/
		.when()
		.delete("https://reqres.in/api/users/2")
		
		/*response*/
		.then()
		.log().all();
		
	}
	
	
}
