package com.backend.NimbblE2EMicroWebServcArch.DPK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Random;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario4_createOrderWithNimblePayment {


	public static void main(String[] args) {
		
		/*https://nimbbl.biz/docs/api-reference/introduction/
		 * 
		 * Base URI: https://api.nimbbl.tech
		 * End-point: /api/v3/generate-token
		 * Request Body:{
  			"access_key": "access_key_pKx7rWVgVpbXQvq2",
  			"access_secret": "access_secret_DX3w55VKAkXbx7aB"
			}
		 * 
		 * After sending the request it will provide the token as:
		 * 
		 * {
  			"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxNTEsInN1Yl9tZXJjaGFudF9pZCI6MjAyLCJleHAiOjE3MTkzMTQ2NzMsInR5cGUiOiJtZXJjaGFudCIsImlhdCI6MTcxOTMxMzQ3MywiaXNzIjoidXJuOm5pbWJibCIsInRva2VuX3R5cGUiOiJ0cmFuc2FjdGlvbiJ9.FmnXa2gN2USyd_SZnu-V1sx5_DkTh75LhVTPa2QJ6Ok",
  			"expires_at": "2024-06-25 11:24:33"
		}
		 * 
		 * */
		
		/*set base URI*/
		baseURI = "https://api.nimbbl.tech/";
			
		System.out.println("=====Authorization post request======");
//API-1 Req	Authorization post request to generate token : https://nimbbl.biz/docs/api-reference/generate-token-v-3/
		String accessKey = "access_key_pKx7rWVgVpbXQvq2";
		String accessSecret = "access_secret_DX3w55VKAkXbx7aB";
		
		String authRequestBody = "{\"access_key\":\""+accessKey+"\",\"access_secret\":\""+accessSecret+"\"}"; 
		
		Response authResponsebody = given()
				.body(authRequestBody)
				.contentType(ContentType.JSON)
				.post("/api/v3/generate-token");
				authResponsebody.then()
				.log().all();
	
		String token = authResponsebody.jsonPath().get("token");
		
		String bearertoken = "Bearer"+token;
		
	
		System.out.println("========Create an order post request========");
		
		/*API-2: create an order post request*/
		String invoiceId = "inv_"+new Random().nextInt();
		String createOrderRequestBody = "{\r\n"
				+ "  \"amount_before_tax\": 2100,\r\n"
				+ "  \"tax\": 105,\r\n"
				+ "  \"total_amount\": 2205,\r\n"
				+ "  \"user\": {\r\n"
				+ "    \"email\": \"wonderwoman@themyscira.gov\",\r\n"
				+ "    \"first_name\": \"Diana\",\r\n"
				+ "    \"last_name\": \"Prince\",\r\n"
				+ "    \"country_code\": \"+91\",\r\n"
				+ "    \"mobile_number\": \"9876543210\"\r\n"
				+ "  },\r\n"
				+ "  \"shipping_address\": {\r\n"
				+ "    \"address_1\": \"1080 Beach Mansion\",\r\n"
				+ "    \"street\": \"Magic Beach Drive\",\r\n"
				+ "    \"landmark\": \"Opposite Magic Mountain\",\r\n"
				+ "    \"area\": \"Elyria\",\r\n"
				+ "    \"city\": \"Atlantis\",\r\n"
				+ "    \"state\": \"Castalia\",\r\n"
				+ "    \"pincode\": \"100389\",\r\n"
				+ "    \"address_type\": \"Beach House\"\r\n"
				+ "  },\r\n"
				+ "  \"currency\": \"INR\",\r\n"
				+ "  \"invoice_id\": \""+invoiceId+",\r\n"
				+ "  \"referrer_platform\": \"string\",\r\n"
				+ "  \"referrer_platform_version\": \"string\",\r\n"
				+ "  \"order_line_items\": [\r\n"
				+ "    {\r\n"
				+ "      \"sku_id\": \"item_2783027490\",\r\n"
				+ "      \"title\": \"Best Sliced Alphonso Mango\",\r\n"
				+ "      \"description\": \"The Alphonso mango is a seasonal fruit harvested from mid-April through the end of June. The time from flowering to harvest is about 90 days, while the time from harvest to ripening is about 15 days.The fruits generally weigh between 150 and 300 grams (5.3 and 10.6 oz), have a rich, creamy, tender texture and delicate, non-fibrous, juicy pulp. As the fruit matures, the skin of an Alphonso mango turns golden-yellow with a tinge of red across the top of the fruit\",\r\n"
				+ "      \"image_url\": \"https://en.wikipedia.org/wiki/Alphonso_mango#/media/File:Alphonso_mango.jpg\",\r\n"
				+ "      \"rate\": 1050,\r\n"
				+ "      \"quantity\": \"2\",\r\n"
				+ "      \"amount_before_tax\": \"2100.00\",\r\n"
				+ "      \"tax\": \"105.00\",\r\n"
				+ "      \"total_amount\": \"2205.00\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"bank_account\": {\r\n"
				+ "    \"account_number\": \"10038849992883\",\r\n"
				+ "    \"name\": \"Diana Prince\",\r\n"
				+ "    \"ifsc\": \"ICIC0000011\"\r\n"
				+ "  },\r\n"
				+ "  \"custom_attributes\": {\r\n"
				+ "    \"name\": \"Diana\",\r\n"
				+ "    \"place\": \"Themyscira\",\r\n"
				+ "    \"animal\": \"Jumpa\",\r\n"
				+ "    \"thing\": \"Tiara\"\r\n"
				+ "  }\r\n"
				+ "}";
		Response createOrderResponseBody = given()
				.header("Authorization", bearertoken)
				.body(createOrderRequestBody)
				.contentType(ContentType.JSON)
				.post("/api/v3/create-order");
				
				createOrderResponseBody.then().log().all();		
		
		String orderId = createOrderResponseBody.jsonPath().get("order_id");
		String userToken = createOrderResponseBody.jsonPath().get("user.token");
		given().auth();	
		
		
		System.out.println("===========Initiate Payment post request========");
		/*API-3: Initiate payment post request*/
		LinkedHashMap<String, String> initiatePaymentHeader = new LinkedHashMap<String, String>();
		initiatePaymentHeader.put("Authorizatin", bearertoken);
		initiatePaymentHeader.put("x-nimbbbl-user-token", userToken);
		String initiatePaymentRequestBody = "{\r\n"
				+ "  \"order_id\": \""+orderId+"\",\r\n"
				+ "  \"callback_url\": \"https://mangoseller.awesome/transaction-response\",\r\n"
				+ "  \"payment_mode_code\": \"net_banking\",\r\n"
				+ "  \"bank_code\": \"hdfc\"\r\n"
				+ "}";
		Response initiatePaymentResponseBody = given()
				.headers(initiatePaymentHeader)
				.body(initiatePaymentRequestBody)
				.contentType(ContentType.JSON)
				.post("/api/v3/initiate-payment");
		
		initiatePaymentResponseBody.then().log().all();
		
	String redirectUrl = initiatePaymentResponseBody.jsonPath().get("next[0].url");
System.out.println(redirectUrl);
	String transactionId = initiatePaymentResponseBody.jsonPath().get("transaction_id");
	
	
	System.out.println("==========webhook payment confirmation============");	
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(redirectUrl);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("username")).sendKeys("payu");
	driver.findElement(By.id("password")).sendKeys("payu");
	driver.findElement(By.xpath("//input[@type='submit']")).click();//click on submit button after entering Un and Pwd
	driver.findElement(By.xpath("//input[@type='submit']")).click();//click on success response button but xpath is same for both
		
System.out.println("==========transaction enquiry post request========");		

	LinkedHashMap<String, String> transactionEnquiryHeader = new LinkedHashMap<String, String>();
	transactionEnquiryHeader.put("Authorization", bearertoken);
	transactionEnquiryHeader.put("x-nimbbl-user-token", userToken);
		
	String transactionEnquiryRequestPayBody = "{\r\n"
			+ "  \"transaction_id\": \""+transactionId+"\",\r\n"
			+ "  \"order_id\": \"o_Rz4Zx2WeyooEpyxa\",\r\n"
			+ "  \"invoice_id\": \"inv_asjjeibdhakk49hnek3\"\r\n"
			+ "}";
	Response transactionEnquiryResponsePayBody = 
			given().headers(transactionEnquiryHeader)
			.body(transactionEnquiryRequestPayBody)
			.contentType(ContentType.JSON).log().all()
			
			.when()
			.post("/api/v3/transaction-enquiry");
	
	transactionEnquiryResponsePayBody.then().log().all();
	String orderStatus = transactionEnquiryResponsePayBody.jsonPath().get("order.status");
	
//	print order status
	System.out.println("Order status :"+orderStatus);
		
		
	}
		
}
