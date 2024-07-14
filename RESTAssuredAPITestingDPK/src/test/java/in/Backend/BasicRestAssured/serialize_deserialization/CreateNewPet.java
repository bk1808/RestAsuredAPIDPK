package in.Backend.BasicRestAssured.serialize_deserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo_classes_utility.Category;

public class CreateNewPet {

	@Test
	public void addPet() {
		
		pojo_classes_utility.CreateNewPet ref = new pojo_classes_utility.CreateNewPet();
		ref.setId(123);
		ref.setName("Scott");
		ref.setCategory(new Category(10, "Dog"));
		ref.setStatus("Active");
		
		/*pre-condition*/
		pojo_classes_utility.CreateNewPet responseObject = given()
		.contentType(ContentType.JSON)
		.body(ref)
		.log().all()
		
		
		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		
		/*response*/
		.then()
		.extract().as(pojo_classes_utility.CreateNewPet.class);
		System.out.println(responseObject.getId());
		System.out.println(responseObject.getName());
		System.out.println(responseObject.getStatus());
		System.out.println(responseObject.getCategory());
		System.out.println(responseObject.getPhotoUrls());
		System.out.println(responseObject.getTags());
	}
	
	
}
