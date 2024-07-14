package in.Backend.BasicRestAssured.requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UpdatePet {

	
	/*In this class we are updating the pet details of perstore 
	 * for providing the formParam form parameter
	 * 1. First you need to create a pet to update
	 * 2. Get petID 
	 * 3. update pet details within the form data as form parameter*/
	@Test
	public void updatePetInfo() {
		
		/*pre-condition*/
		given()
		.pathParam("petId", "9223372016900012592")
		.formParam("name", "Jimni")
		.formParam("status", "Inactive")
		
		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet/{petId}")//this is a method to update pet details with form data
		
		/*response*/
		.then()
		.log().all();
		
		//to cross verify whether the pet details are updated or not[Find pet by ID]
		/*pre-condition*/
		System.out.println();
		System.out.println("===After updating the pet===");
		System.out.println();
		given()
		.pathParam("petId", "9223372016900012592")
		.log().all()
		
		/*http method*/
		.when()
		.get("https://petstore.swagger.io/v2/pet/{petId}")
		
		/*response*/
		.then()
		.log().all();
		
		
	}
	
	
}
