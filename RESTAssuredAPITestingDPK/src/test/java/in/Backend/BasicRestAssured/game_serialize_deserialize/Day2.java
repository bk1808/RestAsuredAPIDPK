package in.Backend.BasicRestAssured.game_serialize_deserialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Day2 {

	public static void main(String[] args) throws Throwable {

		
		FileInputStream fin = new FileInputStream("./src/test/resources/candycrush.ser");
		
		ObjectInputStream obj = new ObjectInputStream(fin);
		CandyCrush user1 = (CandyCrush) obj.readObject();/*to convert the object data into generalized form
		i.e. in the form of CandyCrush class object. This will return the same form 
		as i have stored inside the object. This is deserialization*/
		System.out.println(user1.life);
		System.out.println(user1.levels);
		System.out.println(user1.score);
		
		user1.life = 4;
		user1.levels = 28;
		user1.score = 80000;
		
		FileOutputStream fout = new FileOutputStream("./src/test/resources/candycrush.ser");
		ObjectOutputStream obj1 = new ObjectOutputStream(fout);
		obj1.writeObject(user1);
		
	}

}
