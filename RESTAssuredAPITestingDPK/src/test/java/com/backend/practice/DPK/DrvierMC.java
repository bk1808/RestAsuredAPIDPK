package com.backend.practice.DPK;

import org.testng.annotations.Test;

public class DrvierMC {

	@Test
	public void sampleTest() {

		MethodChaining a = new MethodChaining();

		a.a();
		a.b();
		a.c();
		
		a.a().b().c().d().e();/*example of method chaining after method 'd'
		we can't chain the method of same class but, method 'd' is returning the object
		of class B which has method 'e' we can chain that method after 'e' method we can't
		achieve method chaining since it's not returning anything excep void
		this method chaining applies to static methods also, in that case
		we need not create an objec of the class, we can call directly using class name
		or import methods statically*/
		
	}

}
