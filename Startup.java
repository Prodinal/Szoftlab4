public class Startup {

	private int players_num;
	
	/**\brief Játék indítása
	 * 
	 * Látrehoz egy új engine-t,
	 * inicializálja és meghívja
	 * a play() függvényét.
	 * 
	 */
	
	public void run() {						//KÉSZ not sure about this
		System.out.println("run");
		
		Engine tmp=new Engine();
		tmp.init(players_num);
		
		tmp.play();
	}

	public int getPlayers_num() {				//KÉSZ
		System.out.println("getPlayers_num");
		
		return this.players_num;
	}

	/**
	 * 
	 * @param players_num
	 */
	public void setPlayers_num(int players_num) {			//KÉSZ
		System.out.println("setPlayers_num");
		
		this.players_num = players_num;
	}

}