package com.ninzahrm.api.genericutility;

import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		
		Random ranDom = new Random();
		int randomNumber = ranDom.nextInt(5000);
		return randomNumber;
	}
	
	
}
