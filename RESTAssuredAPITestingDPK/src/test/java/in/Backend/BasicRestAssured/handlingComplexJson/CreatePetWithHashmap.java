package in.Backend.BasicRestAssured.handlingComplexJson;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CreatePetWithHashmap {

	@Test
	public void createPet() {
		
		/*we are declaring key as string and value as object, because we can pass
		 * any type of content or data type such as int, string, array, object*/
		/*for every json object we need to create seperate hashmap since every 
		 * object has key value pair*/
		HashMap<String, Object> category= new HashMap<String, Object>();
		category.put("id", 102);
		category.put("name", "cat");
		
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("https://www.google.com");
		
		HashMap<String, Object> tag1= new HashMap<String, Object>();
		tag1.put("id", 201);
		tag1.put("name", "xyz");
		
		/*ArrayList holding an Hashmap type of data, for every object we create an
		 * Hashmap, since in this case, an Array is holding an object so
		 * we call the hashmap into Arraylist*/
		ArrayList<HashMap<String, Object>> tags= new ArrayList<HashMap<String, Object>>();
		tags.add(tag1);
		
		
		HashMap<String, Object> jsonBody = new HashMap<String, Object>();
		jsonBody.put("id", 0);
		jsonBody.put("category", category);
		jsonBody.put("name", "Tom");
		jsonBody.put("photoUrls", photoUrls);
		jsonBody.put("tags", tags);
		jsonBody.put("status", "Active");
		
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
