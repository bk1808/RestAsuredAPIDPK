package com.ninzahrm.api.genericutility;

import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class JSONUtility {

	FileUtility fLib = new FileUtility();
	String client_id;
	String client_secret;
	
	/**
	 * get the JSON data based on JSON complex Xpath
	 * 
	 * @param resp
	 * @param jsonXpath
	 * @return
	 */
	public String getDataFromJsonPath(Response resp, String jsonXpath) {

		List<Object> list = JsonPath.read(resp.asString(), jsonXpath);

		return list.get(0).toString();
	}

	public String getDataOnXmlPath(Response resp, String xmlXpath) {

		return resp.xmlPath().getString(xmlXpath);

	}

	public boolean verifyDataOnJsonPath(Response resp, String jsonXpath, String expectedData) {

		List<String> list = JsonPath.read(resp.asString(), jsonXpath);
		boolean flag = false;
		for (String str : list) {
			if (str.equals(expectedData)) {
				System.out.println(expectedData + "is available==PASS");
				flag = true;
			}
		}

		return flag;

	}

	public String getAccessToken() throws IOException {

		client_id = fLib.getDataFromPropertiesFile("clientid");
		client_secret = fLib.getDataFromPropertiesFile("clientsecret");
		
		
		Response response = given().formParam("client_id", client_id)
				.formParam("client_secret", client_secret)
				.formParam("grant_type", "client_credentials")

				.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");

		/* capture data from the response */
		String token = response.jsonPath().get("access_token");

		return token;

	}

}
