package in.Backend.BasicRestAssured.reqresCRUD;

import org.testng.annotations.Test;

import io.opentelemetry.api.trace.StatusCode;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class ReqResTest {

/*given() - content type, set cookies, add authentication, add parameters, set header info etc.
  when() - request type or HTTP methods Post, Get, Put/patch, Delete requests
 *then() - validations such as validate status code, extract response, response body, extract headers cookies etc.   
 *and() - we also use this method for validating multiple values
 *these methods are inter-related
 * 
 * */	

	int id;
	
	@Test (priority = 1)
	public void getUsers() {
		
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}
	
	@Test (priority = 2)
	public void createNewUser() {
		
		/*body content*/
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "morpheus");
		data.put("job", "software tester");
		
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
		
	}
	
	@Test (priority = 3, dependsOnMethods = "createNewUser")
	public void updateUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "micheal");
		data.put("job", "automation software tester");
		
		
		given()
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}
	
	@Test (priority = 4)
	public void deleteUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
		
		
	}	
	
	
}
