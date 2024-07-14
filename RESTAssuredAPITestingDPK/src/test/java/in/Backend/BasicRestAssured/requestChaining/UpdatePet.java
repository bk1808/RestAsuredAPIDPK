package in.Backend.BasicRestAssured.requestChaining;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class UpdatePet {

	
	@Test 
	public void updatePet() throws Throwable {
		
		System.out.println("update");
		
		/*update a pet in store with form data, we will collect the petId from .properties
		 * file using FileInputstream class*/
		FileInputStream fin = new FileInputStream("./src/test/resources/config.properties");
		Properties p = new Properties();
		p.load(fin);
		String petId = p.getProperty("petId");
		
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
}
