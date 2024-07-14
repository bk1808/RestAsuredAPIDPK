package in.Backend.BasicRestAssured.game_serialize_deserialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class Day1 {

	public static void main(String[] args) throws Throwable {
		
		/*whenever we are serializing the data, we need to store it inside the 
		 * .ser file or .txt file which is industry standard*/
		
		CandyCrush user1 = new CandyCrush();
		int a = user1.life = 2;
		user1.levels = 18;
		user1.score = 54875;
		
		/*to create a .ser file to convert the object and store as stream of bytes*/
		FileOutputStream fout = new FileOutputStream("./src/test/resources/candycrush.ser");
		
		/*for writing the object data, the data will be in intermediate language*/
		ObjectOutputStream obj = new ObjectOutputStream(fout);
		obj.writeObject(user1);
		
	}
	
	
}
