import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Map {

	private BufferedImage field;

	/**
	 * 
	 * @param s
	 */
	public void load(String s) {						//KÉSZ sort of (nemtudom jó-e lol)
		System.out.println("-> [:Map].load(s)");
	
		try {
			field=ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println("No file with that name exists");
		}
	}

	/**
	 * 
	 * @param c
	 */
	public Boolean fall(Coord c) {						//THIS IS SO BAD BUT I MIGHT WORK FOR TESTS
		System.out.println("->[:Map].fall(c)");
		
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
		System.out.println("->[:Map].putPlayers(numberOfPlayers)");
		
		return new ArrayList<Coord>();
	}

	public BufferedImage getField() {					//KÉSZ
		System.out.println("->[:Map].getField()");
		
		return field;
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(BufferedImage field) {			//KÉSZ
		System.out.println("->[:Map].setField(field)");
		
		this.field=field;
	}

}