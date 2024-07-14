package in.Backend.BasicRestAssured.game_serialize_deserialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Day3 {

	public static void main(String[] args) throws Throwable {

		/*Whenever you are using the application, 
		 * the data should be recorded and stored in some place*/
		FileInputStream fin = new FileInputStream("./src/test/resources/candycrush.ser");
		
		ObjectInputStream obj = new ObjectInputStream(fin);
		CandyCrush user1 = (CandyCrush) obj.readObject();
		
		System.out.println(user1.life);
		System.out.println(user1.levels);
		System.out.println(user1.score);
		
	}

}
