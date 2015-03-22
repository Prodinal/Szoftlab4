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
	
	//UT�LAGOS F�GGV�NYEK
	
	/**\brief Robotok mozgat�sa
	 * 
	 * Minden m�g �l� robotra megh�vja a
	 * calCulateCoords() f�ggv�nyt, �s 
	 * ellen�rzi, hogy leesett-e valamelyik.
	 * Ha igen, akkor azt �tteszi a halott 
	 * robotok k�z�.
	 */
	
	private void moveRobots(){					//K�SZ
		
		System.out.println("Engine.moveRobots()");
		
		for(Robot tmp: alivePlayers){
			tmp.calculateCoords();
			
			Coord newPos=tmp.getPosition();			
			if(map.fall(newPos)){
				dieRobot(tmp);
			}
		}
	}
	
	/**\brief Robotok ellen�rz�se a csapd�kra
	 * 
	 * Egyes�vel elk�ri a robotokt�l
	 * a hely�ket, �s ellen�rizteti az
	 * �sszes csapd�val, hogy belel�pett-e.
	 * Ha igen, akkor �tadja a csapd�nak
	 * a robotot, hogy az be�ll�tsa a 
	 * neki megfelel� m�dos�t�sokat.
	 * 
	 */
	
	private void trapRobots(){					//K�SZ
		
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
	
	/**\brief K�r v�ge
	 * 
	 * Amikor az utols� j�t�kos is elpasszolta
	 * a k�r�t, akkor h�v�dik meg. Megh�vja a
	 * az engine trapRobots() �s moveRobots()
	 * f�ggv�nyeit ilyen sorrendben.
	 * 
	 */
	
	private void roundOver(){					//K�SZ
		
		System.out.println("roundOver");
		
		trapRobots();
		moveRobots();
		
		round_num--;
	}
	
	//PUBLIC, TERVEZETT F�GGV�NYEK
	
	/**\brief Engine konstruktor
	 * 
	 * Inicializ�lja az ArrayList-eket �s
	 * be�ll�tja a max k�r�k sz�m�t. 
	 */
	
	public Engine(){							//K�SZ
		
		System.out.println("Engine()");
		
		alivePlayers=new ArrayList<Robot>();
		deadPlayers=new ArrayList<Robot>();
		traps=new ArrayList<Trap>();
		
		player_num=0;
		round_num=30;
	}
	
	/**\brief A f� playf�ggv�ny, itt fut a j�t�k nagy r�sze
	 * 
	 * Am�g a k�rsz�ml�l� el nem �ri a null�t
	 * egyes�vel v�gigmegy az �l� robotokon,
	 * majd v�r, am�g a kezel�fel�let fel�breszti
	 * a k�r �tpasszol�s�val. Amikor v�gig �rt a 
	 * a robotokon megh�vja a roundOver() f�ggv�nyt.
	 * Amikor elfogytak a k�r�k megh�vja a whoWins()
	 * f�ggv�nyt.
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

	/**\brief J�t�k inicializ�l�sa
	 * 
	 * L�trehozza �s bet�lti a p�ly�t kezel�
	 * objektumot, l�trehoz a param�ter�ben
	 * kapott sz�m� robotot �s lerakja �ket a
	 * p�ly�ra.
	 * 
	 * @param numberOfPlayers
	 */
	public void init(int numberOfPlayers) {			//K�SZ
		
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

	/**\brief K�r passzol�sa
	 * 
	 * A kezel�fel�lett�l kapott vektort
	 * �tadja az �pp akt�v robotnak az
	 * �j modifierek�nt, �s fel�breszti az
	 * Engine.play()-ben v�rakoz� f�sz�lat,
	 * hogy tov�bbl�pjen a j�t�k a k�vetkez�
	 * j�t�kosra.
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

	/**\brief �j csapda hozz�ad�sa
	 * 
	 * Elt�rolja a csapd�k k�z�tt a
	 * param�terben kapott csapd�t.
	 * 
	 * @param x
	 */
	public void addTrap(Trap x) {					//K�SZ
				
		System.out.println("Engine.addTrap(Trap x)");
		
		traps.add(x);
	}

	/**\brief �trakja a robotot a halottak k�z�
	 * 
	 * A param�terben kapott robotot kiveszi az
	 * �l�k k�z�l �s �tteszi a halottak k�z�.
	 * A robot alive flagj�t is �t�ll�tja.
	 * 
	 * @param r
	 */
	public void dieRobot(Robot r) {					//K�SZ
		
		System.out.println("Engine.dieRobot(Robot r)");
		
		alivePlayers.remove(r);
		deadPlayers.add(r);
		r.setAlive(false);
	}

	/**\brief Megn�zi ki nyert
	 * 
	 * V�gign�zi a robotok road attrib�tum�t
	 * �s kiv�lasztja a legnagyobbat.
	 * Ezt elt�rolja a winner attrib�tumban.
	 *  
	 */
	
	public void whoWins() {							//K�SZ
		
		System.out.println("Engine.whoWins()");
		
		Robot winningPlayer=new Robot(this);
		for(Robot tmp: alivePlayers){
			if(tmp.getRoad()>winningPlayer.getRoad()){ winningPlayer=tmp;}
		}
		
		winner=winningPlayer;
	}

	public int getPlayer_num() {					//K�SZ
		System.out.println("Engine.getPlayer_num()");
		
		return this.player_num;
	}

	/**
	 * 
	 * @param player_num
	 */
	public void setPlayer_num(int player_num) {		//K�SZ
		
		System.out.println("Engine.setPlayer_num(int player_num)");
		
		this.player_num = player_num;
	}

	public int getRound_num() {						//K�SZ
		
		System.out.println("Engine.getRound_num()");
		
		return this.round_num;
	}

	/**
	 * 
	 * @param round_num
	 */
	public void setRound_num(int round_num) {		//K�SZ
		
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

	public ArrayList<Trap> getTraps() {				//K�SZ
		
		System.out.println("Engine.getTraps()");
		
		return this.traps;
	}

	/**
	 * 
	 * @param traps
	 */
	public void setTraps(ArrayList<Trap> traps) {	//K�SZ
		
		System.out.println("Engine.setTraps(ArrayList<Trap> traps)");
		
		this.traps = traps;
	}

}