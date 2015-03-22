public class Startup {

	private int players_num;
	
	/**\brief J�t�k ind�t�sa
	 * 
	 * L�trehoz egy �j engine-t,
	 * inicializ�lja �s megh�vja
	 * a play() f�ggv�ny�t.
	 * 
	 */
	
	public void run() {						//K�SZ not sure about this
		System.out.println("run");
		
		Engine tmp=new Engine();
		tmp.init(players_num);
		
		tmp.play();
	}

	public int getPlayers_num() {				//K�SZ
		System.out.println("getPlayers_num");
		
		return this.players_num;
	}

	/**
	 * 
	 * @param players_num
	 */
	public void setPlayers_num(int players_num) {			//K�SZ
		System.out.println("setPlayers_num");
		
		this.players_num = players_num;
	}

}