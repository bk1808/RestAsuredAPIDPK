package com.backend.PANcardMock_Mockito.DPK;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import spark.Spark;

public class CrediCardMock {

	public static void main(String[] args) {

		Spark.port(8889);//end-point, we need to create a port number first
		/* mocking solution with end-point, we need to get two objects [req]&[res]
		 * we need to develop mocking solution for this by using the syntax
		 * with a return statement. Specify the port number and use the mocking
		 * solution syntax, if anyone uses the end-point {/credit-card} and send the request
		 * will be received in 'req' varaible. So, for that we need to create a 'req' mock
		 * for json request. and get the response*/
		Spark.post("/credit-card", (req, res)->{//VVIMP- post request for developing mocking solutions, first argument is end-point, second argument is request and response, develop mocking solution using the syntax
		
			String response = "";
			/* capture the data from the response*/
			String card = JsonPath.read(req.body().toString(), "$.creditcard");//In gson we have to use $-symbol before using any JSON path
			
			if(/*card.equals("1234567891234")*/ StringUtils.equalsAny(card, "1234567891234", "1234567894567")) {//provide mock-data or multiple cards
				
				response = "{ \"status\" : \"Payment success\" }";
				res.status(200);
			}else {  
				
				response = "{ \"status\" : \"Payment failed\" }";
				res.status(404);
			}
			
			res.type("application/json");
			
		return response;
		
		});
		
		System.out.println("============Running...=========");
		
	}

}
