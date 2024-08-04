package com.NinzaHRM.Ninza.Employee.DPK;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninzahrm.api.baseutility.BaseAPIClass;
import com.ninzahrm.api.constants.endpoint.IEndpoint;

import pojo_classes_utility.EmployeePojo;
import pojo_classes_utility.ProjectPojo;

public class EmployeeTest extends BaseAPIClass {

	
	@Test
	public void addEmployeeTest() throws SQLException, IOException {

		String baseUri = fLib.getDataFromPropertiesFile("baseuri");

		int ranNum = jLib.getRandomNumber();

		String projName = "HRM_" + ranNum;
		String userName = "Robert" + ranNum;
		ProjectPojo pojoobject = new ProjectPojo("Praveen", projName, "Created", 10);

		/* pre-condition */
		given()
		.spec(reqSpecObj)
		.body(pojoobject)

				/* http method */
				.when().post(IEndpoint.ADD_EMP)

				/* response */
				.then()
				.spec(resSpecObj)
				.log().all();

		EmployeePojo createEmp = new EmployeePojo("Software Test Engineer", "10/06/1982", "abcd@gmail.com", userName,
				5.5, "6633552552", projName, "ROLE_EMPLOYEE", userName);

		/* pre-condition */
		given()
		.spec(reqSpecObj)//always request spec() builder must be after given() method
		.body(createEmp)

				/* http method */
				.when().post(IEndpoint.ADD_EMP)

				/* response */
				.then()
				.and().time(Matchers.lessThan(3000L))
				.assertThat().statusCode(201)
				.assertThat().spec(resSpecObj)//response spec() builder method must be at the end before log().all() method
				.log().all();

		/* verify emplayee name in the DB */
		dLib.getDBConnection(baseUri, projName, userName);
		boolean flag = dLib.executeQueryVerifyAndGetData("select * from employee", 5, userName);
		Assert.assertTrue(flag, "employee in DB is not verified");
		

	}

	@Test
	public void addEmployeeWithoutEmail() throws SQLException, IOException {

		Random random = new Random();
		int ranNum = random.nextInt(5000);

		String baseUri = fLib.getDataFromPropertiesFile("baseuri");

		String projName = "HRM_" + ranNum;
		String userName = "Robert" + ranNum;
		ProjectPojo pojoobject = new ProjectPojo("Praveen", projName, "Created", 10);

		/* pre-condition */
		given()
		.spec(reqSpecObj)
		.body(pojoobject)

				/* http method */
				.when().post(IEndpoint.ADD_PROJ)

				/* response */
				.then().log().all();

		EmployeePojo createEmp = new EmployeePojo("Software Test Engineer", "10/06/1982", "", userName, 5.5,
				"6633552552", projName, "ROLE_EMPLOYEE", userName);

		/* pre-condition */
		given()
		.spec(reqSpecObj)
		.body(createEmp)

				/* http method */
				.when().post(IEndpoint.ADD_EMP)

				/* response */
				.then().assertThat()
				.assertThat().statusCode(500)
				.spec(resSpecObj)
				.log().all();

	}
	
}
