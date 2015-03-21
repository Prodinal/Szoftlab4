public class Slime extends Trap {

	/**
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KÉSZ
		System.out.println("->[:Coord].springSlime(r)");
		
		int x=r.getModifier().getX()/2;
		int y=r.getModifier().getY()/2;
		
		r.setModifier(new Coord(x, y));
	}

}