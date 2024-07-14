package com.backend.DataDrivenTesting.DPK;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddMultipleProjectsDataProviderDDTest {

	@Test(dataProvider = "getData")
	public void multipleProjectTest(String projectName, String status) {

		baseURI = "http://49.249.28.218:8091";

		String reqBody = "{\r\n" + "  \"createdBy\": \"Praveen\",\r\n" + "  \"projectName\": \"" + projectName
				+ "\",\r\n" + "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 10\r\n" + "}";

		/* pre-condition */
		given().contentType(ContentType.JSON).body(reqBody)

				/* http method execution */
				.when().post("/addProject")

				/* response validation */
				.then()
//				.header("Request URI", "http://49.249.28.218:8091/project?projectId=NH_PROJ_999")
				.log().all();

	}

	@DataProvider
	public Object[][] getData() throws Throwable, IOException {

		ExcelUtility eLib = new ExcelUtility();
		int cellCount = eLib.getCellCount("APIData");
		int rowCount = eLib.getRowCount("APIData");
		System.out.println(cellCount);
		System.out.println(rowCount);
		Object[][] objArr = new Object[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				objArr[i][j] = eLib.getDataFromExcel("APIData", i+1, j);
				objArr[i][j] = eLib.getDataFromExcel("APIData", i+1, j);
			}
		}
		return objArr;

	}

}
