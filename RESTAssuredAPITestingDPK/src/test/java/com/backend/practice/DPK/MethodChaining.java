package com.backend.practice.DPK;

public class MethodChaining {

	public MethodChaining a() {

		System.out.println("==execute method a==");

		return new MethodChaining();
	}

	public MethodChaining b() {

		System.out.println("==execute method b==");

		return new MethodChaining();
	}

	public MethodChaining c() {

		System.out.println("==execute method c==");

		return new MethodChaining();
	}
	
	public B d() {
		
		System.out.println("==execute method d==");
		
		return new B();
	}

}
