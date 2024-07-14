package com.backend.Types_Of_Parameters.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParamTest {
	
	/* creating a formParam to pass the set of data and to filter the data
	 * similar to QueryParam, because in both methods we can pass the key=value pair
	 * we go with formParam because whenever we pass the queryParam, the parameter key=value
	 * is visible in the header, so to avoid that and to secure the API request
	 * even we specify the authentication in the body, which is sensitive*/
	/* In order to send few sensitive parameter data in the request body we prefer to
	 * go for formParam(). 
	 * > Form paramter is not applicable for get() method, and it can be used only for post(), patch(), put()
	 * > Generally, post is used to create resource inside the server, but using post we can also use API for 
	 * authenticate the server by using formParam() by passing sensitive data in request body*/
	
	
	@Test 
	public void formParameterTest() {
		
		baseURI = "http://49.249.28.218:8091";
		
		/*pre-condition*/
		given()
		.queryParam("projectId", "NH_PROJ_999")/*the query parameter is attached in the URI,
		which is not secure http://49.249.28.218:8091/project?teamSize=10*/
		.formParam("projectId", "NH_PROJ_999") /*by using form parameter the queryParam can be sent in the requestBody
		and it'll hide the query request in the URI: http://49.249.28.218:8091/project &
		Form params: teamSize=10 <<[even we can encrypt this data]
		.log().all()//to display request header and body*/
		
		/*http method*/
		.when()
		.post("/project")
		
		/*response validation*/
		.then()
		.log().all();
		
		
		
	}
	
	
}
