package in.Backend.BasicRestAssured.requestHeader;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

import javax.mail.Multipart;

public class PetImageUpload {

	
	@Test
	public void uploadPetImage() {
		
		/*Either i can create a File() object and pass the reference or 
		 * i can create a object directly inside the multiPart() method*/
		/**/
		
		/*pre-condition*/
		given()
		.multiPart(new File("./src/test/resources/images/kitty-cat.jpeg"))//ContentType(multipart/form-data)
		.contentType("multipart/form-data")
		.pathParam("petId", "9223372016900013211")
		.log().all()
		
		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet/{petId}/uploadImage")
		
		/*response*/
		.then()
		.log().all();
		
	}
	
}
