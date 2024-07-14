package com.ninzahrm.api.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninzahrm.api.genericutility.DatabaseUtility;
import com.ninzahrm.api.genericutility.FileUtility;
import com.ninzahrm.api.genericutility.JavaUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo_classes_utility.ProjectPojo;

public class BaseAPIClass {

	public ProjectPojo pojoObj;
	public static RequestSpecification reqSpecObj;//'static' because to use these variables acrss every API test
	public static ResponseSpecification resSpecObj;
	public DatabaseUtility dLib = new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	
	@BeforeSuite
	public void configBS() throws SQLException, IOException {
		
		dLib.getDBConnection();
		System.out.println("====Connect to DB");
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(ContentType.JSON);
//		reqBuilder.addHeader("", "");
//		reqBuilder.setAuth(oauth2(""));
		reqBuilder.setBaseUri(fLib.getDataFromPropertiesFile("baseuri"));
		reqSpecObj = reqBuilder.build();//it will return request specification object
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		resSpecObj = resBuilder.build();
		
		
	}

	
	@AfterSuite
	public void configAS() throws SQLException {
		
		dLib.closeConnection();
		System.out.println("======Close DB connection");
	}

	
}
