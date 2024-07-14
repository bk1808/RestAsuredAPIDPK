package com.backend.practice.DPK;

import static com.backend.StaticImport_Testing.DPK.DemoStaticImport.*;

import org.testng.annotations.Test;

public class Runner {

	
	@Test
	public void sampleTest() {
		
		/*package without static importing*/
		/*DemoStaticImport.given();
		DemoStaticImport.when();
		DemoStaticImport.then();*/
		
		/*package by using static import*/
		given();
		when();
		then();
				
		
	}
	
}
