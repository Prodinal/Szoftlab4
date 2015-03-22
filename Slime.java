public class Slime extends Trap {

	/**\brief Megfelezi a robot modifier-ét.
	 * 
	 * A kapott robot modifier-ét elkéri 
	 * és megfelezi.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KÉSZ
		System.out.println("springSlime");
		
		int x=r.getModifier().getX()/2;
		int y=r.getModifier().getY()/2;
		
		r.setModifier(new Coord(x, y));
	}

}