public class Robot {

	private Coord position;
	private Coord impulse;
	private Coord modifier;
	private int oil_num;
	private int slime_num;
	private double road;
	private Boolean alive;

	private Engine engine;
	
	
	public Robot(Engine x){
		
		System.out.println("Robot()");
		
		position=new Coord();
		modifier=new Coord();
		impulse=new Coord();
		
		oil_num=0;
		oil_num=0;
		road=0;
		alive=true;
		
		engine=x;
	}
	
	public void calculateCoords() {					//K�SZ
		
		System.out.println("Robot.calculateCoords()");
		
		impulse=Coord.add(impulse, modifier);
		position=Coord.add(position, impulse);
		modifier.setX(0);
		modifier.setY(0);
		
		
	}

	public boolean isAlive() {							//K�SZ
		
		System.out.println("Robot.isAlive()");
		
		return alive;
	}

	/**
	 * 
	 * @param pos
	 */
	public void placeOil(Coord pos) {		//K�SZ
		
		System.out.println("Robot.placeOil(Coord pos)");
		
		if(oil_num>0){
			oil_num--;
			
			Oil tmp=new Oil();		
			tmp.setPos(position);
			tmp.setOwner(this);
			
			engine.addTrap(tmp);
		}
	}

	/**
	 * 
	 * @param pos
	 */
	public void placeSlime(Coord pos) {			//K�SZ
		
		System.out.println("Robot.placeSlime(Coord pos)");
		
		if(slime_num>0){
			slime_num--;
			
			Slime tmp=new Slime();		
			tmp.setPos(position);
			tmp.setOwner(this);
			
			engine.addTrap(tmp);
		}
	}

	public Coord getPosition() {				//K�SZ
		System.out.println("Robot.getPosition()");
		
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(Coord position) {			//K�SZ
		System.out.println("Robot.setPosition(Coord position)");
		
		this.position = position;
	}

	public Coord getImpulse() {							//K�SZ
		System.out.println("Robot.getImpluse()");
		
		return this.impulse;
	}

	/**
	 * 
	 * @param impulse
	 */
	public void setImpulse(Coord impulse) {				//K�SZ
		System.out.println("Robot.setImpluse(Coord impulse)");
		
		this.impulse = impulse;
	}

	public Coord getModifier() {						//K�SZ
		System.out.println("Robot.getModifier()");
		
		return this.modifier;
	}

	/**
	 * 
	 * @param modifier
	 */
	public void setModifier(Coord modifier) {			//K�SZ
		System.out.println("Robot.setModifier(Coord modifier)");
		
		this.modifier = modifier;
	}

	public int getOil_num() {							//K�SZ
		System.out.println("Robot.getOil_num()");
		
		return this.oil_num;
	}

	/**
	 * 
	 * @param oil_num
	 */
	public void setOil_num(int oil_num) {				//K�SZ
		System.out.println("Robot.setOil_num()");
		
		this.oil_num = oil_num;
	}

	public int getSlime_num() {							//K�SZ
		System.out.println("Robot.getSlime_num()");
		
		return this.slime_num;
	}

	/**
	 * 
	 * @param slime_num
	 */
	public void setSlime_num(int slime_num) {			//K�SZ
		System.out.println("Robot.setSlime_num(int slime_num)");
		
		this.slime_num = slime_num;
	}

	public double getRoad() {							//K�SZ
		System.out.println("Robot.getRoad()");
				
		return this.road;
	}

	/**
	 * 
	 * @param road
	 */
	public void setRoad(double road) {					//K�SZ
		System.out.println("Robot.setRoad(double road)");
		
		this.road = road;
	}

	public Boolean getAlive() {							//K�SZ
		System.out.println("Robot.getAlive()");
		
		return this.alive;
	}

	/**
	 * 
	 * @param alive
	 */
	public void setAlive(Boolean alive) {				//K�SZ
		System.out.println("Robot.setAlive(Boolean alive)");
		
		this.alive = alive;
	}

}