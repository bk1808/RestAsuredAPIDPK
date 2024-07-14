package in.Backend.BasicRestAssured.requestChaining;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatePet {
	
	@Test
	public void createPet() throws Throwable {
		
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
		long petId = createPetResponse.jsonPath().getLong("id");
		System.out.println("pet Id is: "+petId);//the petId is captured and this will be used across other test methods
		
		/*since the petId is creating within the test method of this class we cannot use
		 * it elsewhere, so with the help of FileoutputStream and properties class
		 * we will create or write this variable inside .properties file*/
		FileOutputStream fout = new FileOutputStream("./src/test/resources/config.properties");
		Properties p = new Properties();
		p.setProperty("petId", ""+petId);//concatinating the petId which is in the Long form, it will become a string value
		p.store(fout, "petId is stored or captured");//to write or create a connection between properties file and file output stream
			
		
		
	}
	
}
