package in.Backend.BasicRestAssured.game_serialize_deserialize;

import java.io.Serializable;

public class CandyCrush implements Serializable {

	/**
	 * The serializable class CandyCrush need to declare a static final
	 * serialVersionUID field of type long
	 */
	
	private static final long serialVersionUID = 1L;
	
	/*the below data needs to be stored somewhere, so to convert the object user1 data 
	 * or to serialize or to convert into stream of bytes and stor, this class should
	 implement 'Serializable' of Java [marker interface] which is empty
	 we should mark this class are serializable only then we can convert*/
	
	int life;
	int levels;
	long score;
	
	public CandyCrush (){
		
		
	}

	public CandyCrush(int life, int levels, long score) {
		
		this.life = life;
		this.levels = levels;
		this.score = score;
	}
	
	
}
