package com.backend.PANcardMock_Mockito.DPK;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreditCardPaymentTest {

	
	@Test
	public void creditCardValidityTest() {
		
		baseURI = "http://localhost:8889";
		
		/*String body = "{ \"creditcard\" : \"1234567891234\", \"cvv\" : \"123\", \"cardname\" : \"praveen\" }\r\n"
				+ "";*/
		
		JSONObject obj = new JSONObject();
		 obj.put("creditcard", "1234567894567");
		 obj.put("cvv", "123");
		 obj.put("cardname", "praveen");
		
		/*pre-condition*/
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		
		/*http method execution*/
		.when()
		.post("/credit-card")
		
		/*response validation*/
		.then()
		.log().all();
		
	}
	
	
	
}
