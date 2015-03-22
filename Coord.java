public class Coord {

	private int X;
	private int Y;

	public Coord(){									//KÉSZ
		System.out.println("Coord()");
	}
	
	
	
	public Coord(int x, int y){							//KÉSZ
		
		System.out.println("Coord(int x, int y)");
		
		X=x; Y=y;
	}
	
	public int getX() {								//KÉSZ
		System.out.println("getX");
		
		return X;
	}

	/**
	 * 
	 * @param a
	 */
	public void setX(int a) {						//KÉSZ
		System.out.println("setX");
		
		X=a;
	}

	public int getY() {								//KÉSZ
		System.out.println("getY");
		
		return Y;
	}

	/**
	 * 
	 * @param b
	 */
	public void setY(int b) {						//KÉSZ
		System.out.println("setY");
		
		Y=b;
	}

	/**\brief Két vektor összeadása
	 * 
	 * Összeadja a két megkapott vektort
	 * és visszatér az új Coord példánnyal.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public static Coord add(Coord pos1, Coord pos2) {		//KÉSZ
		System.out.println("add");
		
		Coord tmp=new Coord(pos1.getX()+pos2.getX(), pos1.getY()+pos2.getY());
		
		return tmp;
	}

}