package com.backend.Types_Of_Parameters.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.InputStream;

public class ParamParameterTest {

	/* created this class to use param() parameter which acts like generic 
	 * queryParam() & formParam()
	 * if we are using param() paramter along with post() request it act like a
	 * formParam() and if we are using along with get() method it act like a queryParam()*/
	
	@Test
	public void paramParamterTest() {
		
		baseURI = "http://49.249.28.218:8091";
		
		/*pre-condition*/
		given()
		.param("projectId", "NH_PROJ_992")
		.contentType("application/json")
//		.body(new File("./data"))
		.log().all()
		
		/*http method*/
		.when()
		.get("/project")
		
		/*reponse validation*/
		.then().log().all();
		
	}
	
}
