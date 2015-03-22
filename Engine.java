import java.util.ArrayList;

public class Engine {

	private int player_num;
	private int round_num;
	private ArrayList<Robot> alivePlayers;
	private ArrayList<Robot> deadPlayers;
	private ArrayList<Trap> traps;
	
	private Map map;
	private Robot activePlayer;
	private Robot winner;
	
	//UTÓLAGOS FÜGGVÉNYEK
	
	/**\brief Robotok mozgatása
	 * 
	 * Minden még élõ robotra meghívja a
	 * calCulateCoords() függvényt, és 
	 * ellenõrzi, hogy leesett-e valamelyik.
	 * Ha igen, akkor azt átteszi a halott 
	 * robotok közé.
	 */
	
	private void moveRobots(){					//KÉSZ
		
		System.out.println("Engine.moveRobots()");
		
		for(Robot tmp: alivePlayers){
			tmp.calculateCoords();
			
			Coord newPos=tmp.getPosition();			
			if(map.fall(newPos)){
				dieRobot(tmp);
			}
		}
	}
	
	/**\brief Robotok ellenõrzése a csapdákra
	 * 
	 * Egyesével elkéri a robotoktól
	 * a helyüket, és ellenõrizteti az
	 * összes csapdával, hogy belelépett-e.
	 * Ha igen, akkor átadja a csapdának
	 * a robotot, hogy az beállítsa a 
	 * neki megfelelõ módosításokat.
	 * 
	 */
	
	private void trapRobots(){					//KÉSZ
		
		System.out.println("Engine.trapRobots()");
		
		for(Robot robot: alivePlayers){
			Coord pos=robot.getPosition();
			
			for(Trap trap: traps){
				if(trap.collide(pos)){
					trap.spring(robot);
				}
			}
		}
	}
	
	/**\brief Kör vége
	 * 
	 * Amikor az utolsó játékos is elpasszolta
	 * a körét, akkor hívódik meg. Meghívja a
	 * az engine trapRobots() és moveRobots()
	 * függvényeit ilyen sorrendben.
	 * 
	 */
	
	private void roundOver(){					//KÉSZ
		
		System.out.println("roundOver");
		
		trapRobots();
		moveRobots();
		
		round_num--;
	}
	
	//PUBLIC, TERVEZETT FÜGGVÉNYEK
	
	/**\brief Engine konstruktor
	 * 
	 * Inicializálja az ArrayList-eket és
	 * beállítja a max körök számát. 
	 */
	
	public Engine(){							//KÉSZ
		
		System.out.println("Engine()");
		
		alivePlayers=new ArrayList<Robot>();
		deadPlayers=new ArrayList<Robot>();
		traps=new ArrayList<Trap>();
		
		player_num=0;
		round_num=30;
	}
	
	/**\brief A fõ playfüggvény, itt fut a játék nagy része
	 * 
	 * Amíg a körszámláló el nem éri a nullát
	 * egyesével végigmegy az élõ robotokon,
	 * majd vár, amíg a kezelõfelület felébreszti
	 * a kör átpasszolásával. Amikor végig ért a 
	 * a robotokon meghívja a roundOver() függvényt.
	 * Amikor elfogytak a körök meghívja a whoWins()
	 * függvényt.
	 */
	
	public void play() {						//PARTIALLY READY
		
		System.out.println("Play");
		
		while(round_num>0){
			for(Robot tmp: alivePlayers){
				activePlayer=tmp;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Engine.play() Wait error ._.");
				}
			}
			roundOver();
		}
		
		whoWins();
	}

	/**\brief Játék inicializálása
	 * 
	 * Látrehozza és betölti a pályát kezelõ
	 * objektumot, létrehoz a paraméterében
	 * kapott számú robotot és lerakja õket a
	 * pályára.
	 * 
	 * @param numberOfPlayers
	 */
	public void init(int numberOfPlayers) {			//KÉSZ
		
		System.out.println("Engine.init(int numberOfPlayers)");
		
		map=new Map();
		map.load("asd");
		
		for(int i=0;i<numberOfPlayers;i++){
			Robot tmp=new Robot(this);
			alivePlayers.add(tmp);
		}
		
		ArrayList<Coord> tmp=map.putPlayers(numberOfPlayers);
		
		for(int i=0;i<numberOfPlayers;i++){
			alivePlayers.get(i).setPosition(tmp.get(i));
		}
	}

	/**\brief Kör passzolása
	 * 
	 * A kezelõfelülettõl kapott vektort
	 * átadja az épp aktív robotnak az
	 * új modifiereként, és felébreszti az
	 * Engine.play()-ben várakozó fõszálat,
	 * hogy továbblépjen a játék a következõ
	 * játékosra.
	 * 
	 * @param modifier
	 */
	public void turnPassed(Coord modifier) {		//TO BE REVIEWED
		
		System.out.println("Engine.turnPassed(Coord modifier)");
		
		activePlayer.setModifier(modifier);
		
		notifyAll();
		
//		int index=alivePlayers.indexOf(activePlayer);
//		Robot newActivePlayer=alivePlayers.get((index+1)%alivePlayers.size());		//O.o
//		
//		activePlayer=newActivePlayer;
//		
//		//activePlayer=alivePlayers.get((alivePlayers.indexOf(activePlayer)+1)%alivePlayers.size());
	}

	/**\brief Új csapda hozzáadása
	 * 
	 * Eltárolja a csapdák között a
	 * paraméterben kapott csapdát.
	 * 
	 * @param x
	 */
	public void addTrap(Trap x) {					//KÉSZ
				
		System.out.println("Engine.addTrap(Trap x)");
		
		traps.add(x);
	}

	/**\brief Átrakja a robotot a halottak közé
	 * 
	 * A paraméterben kapott robotot kiveszi az
	 * élõk közül és átteszi a halottak közé.
	 * A robot alive flagját is átállítja.
	 * 
	 * @param r
	 */
	public void dieRobot(Robot r) {					//KÉSZ
		
		System.out.println("Engine.dieRobot(Robot r)");
		
		alivePlayers.remove(r);
		deadPlayers.add(r);
		r.setAlive(false);
	}

	/**\brief Megnézi ki nyert
	 * 
	 * Végignézi a robotok road attribútumát
	 * és kiválasztja a legnagyobbat.
	 * Ezt eltárolja a winner attribútumban.
	 *  
	 */
	
	public void whoWins() {							//KÉSZ
		
		System.out.println("Engine.whoWins()");
		
		Robot winningPlayer=new Robot(this);
		for(Robot tmp: alivePlayers){
			if(tmp.getRoad()>winningPlayer.getRoad()){ winningPlayer=tmp;}
		}
		
		winner=winningPlayer;
	}

	public int getPlayer_num() {					//KÉSZ
		System.out.println("Engine.getPlayer_num()");
		
		return this.player_num;
	}

	/**
	 * 
	 * @param player_num
	 */
	public void setPlayer_num(int player_num) {		//KÉSZ
		
		System.out.println("Engine.setPlayer_num(int player_num)");
		
		this.player_num = player_num;
	}

	public int getRound_num() {						//KÉSZ
		
		System.out.println("Engine.getRound_num()");
		
		return this.round_num;
	}

	/**
	 * 
	 * @param round_num
	 */
	public void setRound_num(int round_num) {		//KÉSZ
		
		System.out.println("Engine.setRound_num(int numberOfRounds)");
		
		this.round_num = round_num;
	}

//	public ArrayList<Robot> getPlayers() {			//Ez szerintem nem fog kelleni
//		throw new UnsupportedOperationException();
//	}
//
//	/**
//	 * 
//	 * @param players
//	 */
//	public void setPlayers(ArrayList<Robot> players) {
//		throw new UnsupportedOperationException();
//	}

	public ArrayList<Trap> getTraps() {				//KÉSZ
		
		System.out.println("Engine.getTraps()");
		
		return this.traps;
	}

	/**
	 * 
	 * @param traps
	 */
	public void setTraps(ArrayList<Trap> traps) {	//KÉSZ
		
		System.out.println("Engine.setTraps(ArrayList<Trap> traps)");
		
		this.traps = traps;
	}

}