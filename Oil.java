public class Oil extends Trap {

	/**
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//K�SZ
		System.out.println("->[:Oil].springOil(r)");
		
		r.setModifier(new Coord(0,0));
	}

}