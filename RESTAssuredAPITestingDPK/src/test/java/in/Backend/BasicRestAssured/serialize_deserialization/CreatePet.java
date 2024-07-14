package in.Backend.BasicRestAssured.serialize_deserialization;

import org.hamcrest.Matchers;
import org.mockito.internal.matchers.LessThan;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import jdk.jfr.internal.util.Matcher;
import pojo_classes_utility.Category;
import pojo_classes_utility.CreateNewPet;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreatePet {

	
	@Test
	public void addPet() {
		
		/*Java POJO object, now, this java object will be converted into json object 
		 * with the help of dependency called jackson-databind present in Pom.xml fil
		 * it will serialize and deserialize the java to json and json to java. 
		 * The result or response in the console will be in json*/
		/* to convert json to java object we need to extract the data from response body
		 * as 'CreateNewPet' class and create a response variable at given() method
		 * as CreateNewPet type, now using this responseObject you can get the data*/
		CreateNewPet ref = new CreateNewPet();
		ref.setName("scooby");
		ref.setCategory(new Category(10, "Dog"));
		ref.setStatus("Active");
		
		/*pre-condition*/
		CreateNewPet responseObject = given()
		.contentType(ContentType.JSON)
		.body(ref)
		.log().all()
		
		/*http method*/
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		
		/*response*/
		.then()
		
		.extract().as(CreateNewPet.class);
		System.out.println(responseObject.getId());
		System.out.println(responseObject.getName());
		System.out.println(responseObject.getStatus());
	}
	
	
}
