package in.Backend.BasicRestAssured.requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PetStore_requestChainingSameClass {

	/*REQUEST CHAINING CONCEPT*/
	/*In this class i am using multiple @Test methods using testNG 'priority but, the 
	 * drawack is, if createPet test case fails the rest of the @test methods 
	 * should not execute as there's no pet created. Hence, to fail the remaining test
	 * methods we go for dependsOnMethods instruction
	 * After creating multiple test methods
	 * > i am creating a dependancy between test methods
	 * > inside test methods i am writing the API request script 
	 * > i have created a petId as global variable since it's passed in every test methods
	 * > where i have captured the data of petId and same i have provided across the script*/
	
	long petId;//to use this variable inside another test case i am declaring it as global variable
	
	@Test (/*priority = 1*/)
	public void createPet() {
		
		System.out.println("create");
		/*pre-condition*/
		Response createPetResponse = given()
		.contentType(ContentType.JSON)
		.body(new File("./src/test/resources/createPet.json"))
		
		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet");//to capture the entire response we will end the statement here
		
		/*response*/
		createPetResponse.then().log().all();
		petId = createPetResponse.jsonPath().getLong("id");
		System.out.println("pet Id is: "+petId);//the petId is captured and this will be used across other test methods
		
	}
	
	
	@Test (/*priority = 2*/ dependsOnMethods = "createPet")
	public void updatePet() {
		
		System.out.println("update");
		
		/*update a pet in store with form data*/
		
		/*pre-condition*/
		given()
		.pathParam("petId", petId)
		.formParam("name", "Tommy")
		.formParam("status", "sold out")
		
		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet/{petId}")
		
		
		/*response*/
		.then()
		.log().all();
	}
	
	@Test (/*priority = 3*/ dependsOnMethods = "updatePet")
	public void readPet() {
		
		System.out.println("read");
		/*pre-condition*/
		given()
		.pathParam("petId", petId)
		
		/*http method*/
		.when()
		.get("https://petstore.swagger.io/v2/pet/{petId}")
		
		/*response*/
		.then()
		.log().all();
		
	}
	
	@Test (/*priority = 4*/ dependsOnMethods = "readPet")
	public void deletePet() {
		
		System.out.println("delete");
		
		/*pre-condition*/
		given()
		.pathParam("petId", petId)
		
		
		/*http method*/
		.when()
		.delete("https://petstore.swagger.io/v2/pet/{petId}")
		
		/*response*/
		.then()
		.log().all();
	}
}