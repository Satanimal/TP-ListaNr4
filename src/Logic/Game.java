package Logic;

import java.io.Serializable;
import java.util.ArrayList;

import Models.Stone;
import Server.GameLoopThread;
import Server.Server;

/**
 * Klasa zawieraj�ca wszystkie informacje na temat tocz�cej si�, lub utworzonej gry po stronie serwera
 */
public class Game implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int generalId;
	private int id;
	private ArrayList<IPlayer> players;
	private ArrayList<Stone> board;
	
	/**
	 * Kontruktor
	 */
	public Game(){
		id = generalId;
		generalId++;
		board = new ArrayList<Stone>();
		players = new ArrayList<IPlayer>();
	}
	
	/**
	 * Rozpoczyna rozgrywk� po do��czeniu dw�ch graczy
	 */
	public void StartGame(){
		Server.SetPlayerSides(id);
		new Thread(new GameLoopThread(this)).start();
	}
	
	static{
		generalId = 0;
	}
	
	
	
	public ArrayList<Stone> getBoard() {
		return board;
	}
	
	public ArrayList<IPlayer> getPlayers() {
		return players;
	}
	
	public int getId(){
		return id;
	}
}
