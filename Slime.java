public class Slime extends Trap {

	/**\brief Megfelezi a robot modifier-�t.
	 * 
	 * A kapott robot modifier-�t elk�ri 
	 * �s megfelezi.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//K�SZ
		System.out.println("springSlime");
		
		int x=r.getModifier().getX()/2;
		int y=r.getModifier().getY()/2;
		
		r.setModifier(new Coord(x, y));
	}

}