import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Map {

	private BufferedImage field;

	/**\brief Bet�lti a kapott p�ly�t
	 * 
	 * A kapott string alapj�n megnyitja
	 * �s elt�rolja a k�pet.
	 * 
	 * @param s
	 */
	public void load(String s) {						//K�SZ sort of (nemtudom j�-e lol)
		System.out.println("load");
	
		try {
			field=ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println("No file with that name exists");
		}
	}

	/**\brief Megn�zi leesett-e a robot
	 * 
	 * Megn�zi a robot jelenlegi hely�t,
	 * �s ha az a p�ly�n a szakad�k sz�ne,
	 * akkor visszat�r true-val, jelezve,
	 * hogy a robot a m�lybe zuhant.
	 *
	 * @param c
	 */
	public Boolean fall(Coord c) {						//THIS IS SO BAD BUT I MIGHT WORK FOR TESTS
		System.out.println("fall");
		
		if(field.getRGB(c.getX(), c.getY()) == Color.BLACK.getRGB()){
			return true;
		}else
			return false;
	}

	/**
	 * 
	 * @param numberOfPlayers
	 */
	public ArrayList<Coord> putPlayers(int numberOfPlayers) {			//TO BE FILLED LATER
		System.out.println("putPlayers");
		
		return new ArrayList<Coord>();
	}

	public BufferedImage getField() {					//K�SZ
		System.out.println("getField");
		
		return field;
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(BufferedImage field) {			//K�SZ
		System.out.println("setField");
		
		this.field=field;
	}

}