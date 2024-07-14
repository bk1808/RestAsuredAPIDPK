package com.shopperstack.ecommerce.login;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ShopperLogin {

	@Test
	public void shopperLogin() {
		
		//given()
		
		when()
		
			.get("https://www.shoppersstack.com/shopping")

		.then()
		.statusCode(200)
		//.body()
		.log().all();
		
	}
	
}
