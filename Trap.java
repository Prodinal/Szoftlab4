public class Trap {

	private Coord pos;
	private int r;
	private Robot owner;

	/**
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//K�SZ
		System.out.println("springTrap");
	}

	/**\brief �tk�zik-e a robot a csapd�val
	 * 
	 * Megn�zi, hogy a kapott koordin�ta
	 * beleesik-e a csapda k�r�li r sugar�
	 * k�rbe �s ennek megfelel�en
	 * visszat�r egy bool-lal.
	 * 
	 * @param c
	 */
	public Boolean collide(Coord c) {			//K�SZ
		System.out.println("collide");
		
		if((c.getX()-pos.getX())*(c.getX()-pos.getX())+(c.getY()-pos.getY())*(c.getY()-pos.getY())<=r*r){		//(x-x0)^2+(y-y0)^2<=R^2
			return true;
		}
		
		return false;
	}

	public Coord getPos() {						//K�SZ
		System.out.println("getPos");	
		
		return this.pos;
	}

	/**
	 * 
	 * @param pos
	 */
	public void setPos(Coord pos) {				//K�SZ
		System.out.println("setPos");
		
		this.pos = pos;
	}

	public int getR() {							//K�SZ
		System.out.println("getR");
		
		return this.r;
	}

	/**
	 * 
	 * @param r
	 */
	public void setR(int r) {					//K�SZ
		System.out.println("setR");
		
		this.r = r;
	}

	public Robot getOwner() {					//K�SZ
		System.out.println("getOwner");
		
		return this.owner;
	}

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(Robot owner) {				//K�SZ
		System.out.println("setOwner");
		
		this.owner = owner;
	}

}