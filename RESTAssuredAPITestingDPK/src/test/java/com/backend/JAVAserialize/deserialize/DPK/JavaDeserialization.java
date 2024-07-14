package com.backend.JAVAserialize.deserialize.DPK;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class JavaDeserialization {

	public static void main(String[] args) throws Throwable {

		
		FileInputStream fin = new FileInputStream("./src/test/resources/NFSgame.ser");
		ObjectInputStream obj = new ObjectInputStream(fin);
		NFSgame user1 = (NFSgame) obj.readObject();//downcasting from object o NFSgame
		
		System.out.println(user1.name);
		System.out.println(user1.level);
		System.out.println(user1.life);
		System.out.println(user1.score);
		System.out.println("===complete===");
		
		
		
	}

}
