package com.backend.StaticImport_Testing.DPK;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTest {


	@Test
	public void sampleGetRequestTest() {
		
		/* if we do a static import, then we need not have to mention
		 * the class name, this is available only in JDK 1.5 version above
		 * similary in RestAssured there are all static methods hence
		 * we go for static import*/
		DemoStaticImport.given();
		DemoStaticImport.when();
		DemoStaticImport.then();
		
		Response response = get("https://reqres.in/api/users?page=2");//executes via http protocol
		
		System.out.println(response.prettyPrint());//prettyPrint will display response body
	}
}
