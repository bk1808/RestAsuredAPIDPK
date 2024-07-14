package in.Backend.BasicRestAssured.requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetPetDetails {

	/*in this class we are learning how to pass the path parameter to base-URL
	 * For this getter method first you need to run-CreatePetWithHashmap class present
	 * in handlingComplexJson package*/
	@Test
	public void getPetInfo() {
		
		/*pre-condition*/
		given()
		.pathParam("petID", "9223372016900012534")
		.body("")
		.log().all()
		
		/*http method*/
		.when()
		.get("https://petstore.swagger.io/v2/pet/{petID}")//path parameter key should be taken here as it's
		
		/*response*/
		.then()
		.log().all();
		
	}
	
	
	
}
