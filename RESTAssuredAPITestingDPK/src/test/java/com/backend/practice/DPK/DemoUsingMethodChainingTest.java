package com.backend.practice.DPK;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DemoUsingMethodChainingTest {

	/*this class is an example of method chaining*/
	@Test
	public void getRequestTest() {
		
		
		JsonObject body = new JsonObject();
		body.addProperty("projectName", "HRM_001");
		body.addProperty("teamSize", 10);
		body.addProperty("active", true);
		body.addProperty("status", "active");
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(body)
		.auth().basic("rmgyantra", "rmg@123")
		.auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MTk0NjQwNzEsImlhdCI6MTcxOTQ2MjMzNywianRpIjoiMzUzNGU5ZDItZmVjNi00OGY3LWJkNzMtY2RlZWViYzAxYzA3IiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiMTYzNGI4OGMtNDhhMS00YmMyLWI0ZDUtOWM1YTc0OGQxMWNlIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiMTYzNGI4OGMtNDhhMS00YmMyLWI0ZDUtOWM1YTc0OGQxMWNlIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.UojybpLT6DogkOYJlx_Ua10PZkrWY2CFX8c-m7QcMgMuepYiT4J3CydLCrKRLXQtwgHLbko8QHK1W0vvLZTN4JI2fseJqZvSRGiHw5Mekz9xPnVp7fA01ZjTEHDXmmE-dZePZY9bnrjyrBQu_qC3WMnpSnW2M5mFJxwUcKV91O5rk9EzZEeOy6WmMNXKfD9968gVca5pNuvQ5a6CDc-6jiiWENsnzaQhCUdJZaXeRVegV3D7Nf6tGScDBC7k5iGWBjGdcDPepVC3ghK1oBsCZ08Oq1dTb4_pgw7UpwgTtOjacv3LFTIXqBDUUiQKDsOIVBIJemCyhvX1CRZT-DHpsQ")
		.auth().digest("rmgyantra", "rmgy@9999")
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when()
		.post("https://reqres.in/api/users?page=2");
		
		
	
		response.then().log().all();
		
		
		
		/*prettyPrint() method will return only response paylod wherein
		 * log.all() will return the complete log information along with response*/
		
	}
	
	
}
