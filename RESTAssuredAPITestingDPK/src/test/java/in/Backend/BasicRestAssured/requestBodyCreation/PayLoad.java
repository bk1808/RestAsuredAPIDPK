package in.Backend.BasicRestAssured.requestBodyCreation;

public class PayLoad {

	/*we need to create static methods to make them available across the packages
	 * copy paste the request method body. This will segregate the JSON body from the 
	 * actual script. We use this method for complicatted JSON request body*/
	
	public static String createUser() {
		
		return "{\r\n"
				+ "    \"name\": \"praveen\",\r\n"
				+ "    \"job\": \"software tester\"\r\n"
				+ "}";
		
	}
	
}
