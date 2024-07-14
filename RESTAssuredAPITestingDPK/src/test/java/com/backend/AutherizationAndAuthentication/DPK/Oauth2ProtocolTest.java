package com.backend.AutherizationAndAuthentication.DPK;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2ProtocolTest {

	@Test
	public void oAuth2ProtocolTest() {

		/* Oauth-2 protocol provide high security */

		baseURI = "http://49.249.28.218:8091";

		/* pre-condition */
		Response response = given().formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials")

				/* http method execution, the token will be generated */
				.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");

		/* the access_token is being captured */

		String token = response.jsonPath().get("access_token");
		System.out.println(token);

		/* response validation */
		response.then().statusCode(200);
		response.then().log().all();

		/* using the token send the API-request */

		given().auth().oauth2(token).log().all()

				/* htto method execution */
				.get("/projects")

				/* response validation */
				.then().log().all();

	}

}
