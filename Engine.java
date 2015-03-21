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
	
	private void moveRobots(){					//KÉSZ
		
		System.out.println("moveRobots");
		
		for(Robot tmp: alivePlayers){
			tmp.calculateCoords();
			
			Coord newPos=tmp.getPosition();			
			if(map.fall(newPos)){
				dieRobot(tmp);
			}
		}
	}
	
	private void trapRobots(){					//KÉSZ
		
		System.out.println("trapRobots");
		
		for(Robot robot: alivePlayers){
			Coord pos=robot.getPosition();
			
			for(Trap trap: traps){
				if(trap.collide(pos)){
					trap.spring(robot);
				}
			}
		}
	}
	
	private void roundOver(){					//KÉSZ
		
		System.out.println("roundOver");
		
		trapRobots();
		moveRobots();
		
		round_num--;
	}
	
	//PUBLIC, TERVEZETT FÜGGVÉNYEK
	
	public Engine(){							//KÉSZ
		
		System.out.println("Engine()");
		
		alivePlayers=new ArrayList<Robot>();
		deadPlayers=new ArrayList<Robot>();
		traps=new ArrayList<Trap>();
		
		player_num=0;
		round_num=30;
	}
	
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

	/**
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

	/**
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

	/**
	 * 
	 * @param x
	 */
	public void addTrap(Trap x) {					//KÉSZ
				
		System.out.println("Engine.addTrap(Trap x)");
		
		traps.add(x);
	}

	/**
	 * 
	 * @param r
	 */
	public void dieRobot(Robot r) {					//KÉSZ
		
		System.out.println("Engine.dieRobot(Robot r)");
		
		alivePlayers.remove(r);
		deadPlayers.add(r);
		r.setAlive(false);
	}

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