public class Coord {

	private int X;
	private int Y;

	public Coord(){									//K�SZ
		System.out.println("Coord()");
	}
	
	
	
	public Coord(int x, int y){							//K�SZ
		
		System.out.println("Coord(int x, int y)");
		
		X=x; Y=y;
	}
	
	public int getX() {								//K�SZ
		System.out.println("getX");
		
		return X;
	}

	/**
	 * 
	 * @param a
	 */
	public void setX(int a) {						//K�SZ
		System.out.println("setX");
		
		X=a;
	}

	public int getY() {								//K�SZ
		System.out.println("getY");
		
		return Y;
	}

	/**
	 * 
	 * @param b
	 */
	public void setY(int b) {						//K�SZ
		System.out.println("setY");
		
		Y=b;
	}

	/**\brief K�t vektor �sszead�sa
	 * 
	 * �sszeadja a k�t megkapott vektort
	 * �s visszat�r az �j Coord p�ld�nnyal.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public static Coord add(Coord pos1, Coord pos2) {		//K�SZ
		System.out.println("add");
		
		Coord tmp=new Coord(pos1.getX()+pos2.getX(), pos1.getY()+pos2.getY());
		
		return tmp;
	}

}