package com.backend.JAVAserialize.deserialize.DPK;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSgame implements Serializable {
	
	/* Serializable & Clonable are Marker interfaces in Java
	 * */
	String name;
	int level;
	int score;
	int life;	
	
	private NFSgame() {
		super();	
	}

	public NFSgame(String name, int level, int score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class JavaSerialization {

	public static void main(String[] args) throws Throwable {

		NFSgame user1 = new NFSgame("Praveen", 15, 60000, 1);
		FileOutputStream fout = new FileOutputStream("./src/test/resources/NFSgame.ser");
		ObjectOutputStream obj = new ObjectOutputStream(fout);		
		obj.writeObject(user1);
		System.out.println("==complete==");
	}

}
