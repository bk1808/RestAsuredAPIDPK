package in.Backend.BasicRestAssured.reqresCRUD;

import java.util.HashMap;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class DifferentWaysToCreatePostRequestBody {

	/**
	 
1. Post request by using Hashmap
2. Post request by using org.json library
3. Post request by using POJO class - Plain Old Java Object [you need to create a java class, famous way]
4. Post request by using external json file
	 
	 */
	
	@Test (priority = 1)
	public void testPostUsingHashmap() {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("name", "scott");
		data.put("location", "london");
		data.put("phone", "225252");
		
		String coursesArray [] = {"C", "C++", "C#"};
		data.put("courses", coursesArray);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("scott"))
		.body("location", equalTo("london"))
		.body("phone", equalTo(225252))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.body("courses[2]", equalTo("C#"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	@Test (priority = 2)
	public void deleteRecord() {
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/4")
		
		.then()
		.statusCode(200);
		
	}

	
	
}
