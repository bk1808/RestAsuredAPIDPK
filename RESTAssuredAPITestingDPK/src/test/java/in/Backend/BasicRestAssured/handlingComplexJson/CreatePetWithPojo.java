package in.Backend.BasicRestAssured.handlingComplexJson;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo_classes_utility.Category;
import pojo_classes_utility.CreateNewPet;
import pojo_classes_utility.Tags;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class CreatePetWithPojo {

	@Test
	public void createAPet() {
		
		Category category = new Category(101, "Cats");
		ArrayList<String> photoUrls = new ArrayList<String>();
		Tags tag1 = new Tags(11, "Mew");
		ArrayList<Tags> tags = new ArrayList<Tags>();
		Tags tag2 = new Tags(12, "oww");
		
		photoUrls.add("https://www.google.com");
			
		CreateNewPet jsonBody = new CreateNewPet(0, category, "mili", photoUrls, tags, "available");
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(jsonBody)
		.log().all()

		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		
		/*response*/
		.then()
		.log().all();
	}
	
	
}
