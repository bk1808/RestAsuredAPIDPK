package com.shopperstack.ecommerce.login;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ShopperLogin {

	@Test
	public void shopperLogin() {
		
		
		String loginBody = "{\r\n"
				+ "  \"email\": \"praveen.123@gmail.com\",\r\n"
				+ "  \"password\": \"Password@123\",\r\n"
				+ "  \"role\": \"Shopper\"\r\n"
				+ "}";
		
		given()
		.contentType("application/json")
		.body(loginBody)
		
		.when()
		
		.get("https://www.shoppersstack.com/shopping")

		.then()
		.statusCode(200)
		//.body()
		.log().all();
		
	}
	
}
