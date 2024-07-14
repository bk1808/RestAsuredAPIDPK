package in.Backend.BasicRestAssured.requestChaining;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadPet {

	
	@Test 
	public void readPet() throws Throwable {
		
		System.out.println("read");
		
		FileInputStream fin = new FileInputStream("./src/test/resources/config.properties");
		Properties p = new Properties();
		p.load(fin);
		String petId = p.getProperty("petId");
		
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
}
