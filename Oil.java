public class Oil extends Trap {

	/**\brief Kinull�zza a robot modifier�t.
	 * 
	 * A kapott robot modifier�t null�ra �ll�tja.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//K�SZ
		System.out.println("springOil");
		
		r.setModifier(new Coord(0,0));
	}

}