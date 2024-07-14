package com.backend.PANcardMock_Mockito.DPK;

import org.mockito.Mockito;
import org.testng.Assert;

class PANCard {

	/**
	 * Mock for PAN card validation-stub Instead of DigiLocked - this is a 'Stub' in
	 * replacement of that, to test this stub we must use the mock-data/synthetic
	 * data provided by the developers
	 * 
	 * @param panCard
	 * @return
	 */

	public String isValid(String panCard) {

		if (panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}") == true) {

			return "It's a valid PAN card";

		} else {
			return "It's invalid PAN card";
		}
	}

	/**
	 * method to create mock object for PAN card, to develop mocking solution using
	 * Mockito class we add mock data and pass the Class of mocking solution to be
	 * sent as argument which will return the same class object, using this object
	 * we call the isValid() method of Stub class Develop dummy PAN card number
	 * using Mockito-with when() pass the PANCard class method and pass the
	 * mock-data one valid and two invalid data provided by the Dev.
	 */
	public static PANCard getMockObject() {

		PANCard mockObject = Mockito.mock(PANCard.class);// It'll return the same class object
		Mockito.when(mockObject.isValid("ABCDE1234A")).thenReturn("Valid PAN card");// valid
		Mockito.when(mockObject.isValid("ABCDE1234B")).thenReturn("Valid PAN card");// valid
		Mockito.when(mockObject.isValid("ABCDE1234C")).thenReturn("invalid PAN card");// invalid

		return mockObject;
	}

}

/**
 * main class for creating mock test and validate the PAN card mock data
 * 29-Jun-2024
 */
public class MockingTest {

	/**
	 * Steps to validate the JAVA Mockito Mocking solution [we need to add Mockito
	 * dependancy] 1. Create a inner class for PANCard and create a isValid() method
	 * 2. Create a non-static method called isValid() which returns the boolean value
	 * of a method 3. Inside isValid method create a if.else block with condition and using
	 * string variable call Matches method and pass the PAN card syntax
	 * [A-Z]{5}[0-9]{4}[A-Z]{1} since PAN cord a combination of ABCDE1234F then
	 * declare it as true if the pattern of PAN card matches else declare it as false
	 * 4. Create another static method within inner class as getMockObject() 5.
	 * Install Mockito dependancy from MVN repo, with the help of 'Mockito' class
	 * call mock() method inside mock(PANCard.class) method pass PANCard class as an
	 * ojbect which will return the same class object 6. Using Mockito class call
	 * when() method using PANCard class object refrence call isValid() and pass
	 * mock-data using thenReturn() method enter the statment for validation 7.
	 * getMockObject() method should retrun the PANCard class object 8. Inside the
	 * public class main method, create an oject for PANCard class 9. Validate the
	 * mock-data using Assert.assertEquals method 10. If it return the statment as
	 * valid, the PAN is valid else invalid
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		PANCard object = PANCard.getMockObject();
		System.out.println(object.isValid("ABCDE1234A"));
//		even thogh below data comes under schema of the PAN card, it will through exception because it's not a mock data
		Assert.assertEquals(object.isValid("ABCDE1234A"), "Valid PAN card");

//		System.out.println(PANCard.isValid("BLMMP1258S"));;

	}

}
