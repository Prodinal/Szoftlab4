public class Trap {

	private Coord pos;
	private int r;
	private Robot owner;

	/**
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KÉSZ
		System.out.println("springTrap");
	}

	/**\brief Ütközik-e a robot a csapdával
	 * 
	 * Megnézi, hogy a kapott koordináta
	 * beleesik-e a csapda körüli r sugarú
	 * körbe és ennek megfelelõen
	 * visszatér egy bool-lal.
	 * 
	 * @param c
	 */
	public Boolean collide(Coord c) {			//KÉSZ
		System.out.println("collide");
		
		if((c.getX()-pos.getX())*(c.getX()-pos.getX())+(c.getY()-pos.getY())*(c.getY()-pos.getY())<=r*r){		//(x-x0)^2+(y-y0)^2<=R^2
			return true;
		}
		
		return false;
	}

	public Coord getPos() {						//KÉSZ
		System.out.println("getPos");	
		
		return this.pos;
	}

	/**
	 * 
	 * @param pos
	 */
	public void setPos(Coord pos) {				//KÉSZ
		System.out.println("setPos");
		
		this.pos = pos;
	}

	public int getR() {							//KÉSZ
		System.out.println("getR");
		
		return this.r;
	}

	/**
	 * 
	 * @param r
	 */
	public void setR(int r) {					//KÉSZ
		System.out.println("setR");
		
		this.r = r;
	}

	public Robot getOwner() {					//KÉSZ
		System.out.println("getOwner");
		
		return this.owner;
	}

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(Robot owner) {				//KÉSZ
		System.out.println("setOwner");
		
		this.owner = owner;
	}

}