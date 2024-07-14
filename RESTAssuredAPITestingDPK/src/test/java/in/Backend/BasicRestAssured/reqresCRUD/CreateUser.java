package in.Backend.BasicRestAssured.reqresCRUD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUser {

	@Test
	public void createAUser() {
		
		/*pre-condition, call the given() static method present in rest assured class
		in postman by default content type will selected as application/json but in 
		rest assured we need to explicitly specify, provide the body which accepts 'string 
		type of argument. We should not copy paste the body directly similar to postman
		*/
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		/*provide the type of http method, inside the post method specify the url*/
		
		.when()
		.post("https://reqres.in/api/users")
		
		/*response section*/
		
		.then()
		.assertThat().time(Matchers.lessThan(3000L))
		.log().all();/*to see the response body, and header in the
		console we use this method. And, we need to end the script with ; - semi-colon
		after this run as testNG*/
		
	}
	
	
}
