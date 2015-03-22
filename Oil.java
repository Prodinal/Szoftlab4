public class Oil extends Trap {

	/**\brief Kinullázza a robot modifierét.
	 * 
	 * A kapott robot modifierét nullára állítja.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KÉSZ
		System.out.println("springOil");
		
		r.setModifier(new Coord(0,0));
	}

}