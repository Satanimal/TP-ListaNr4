package Logic;

import java.util.ArrayList;

import Models.Stone;

public class Game {
	private static int id;
	private ArrayList<IPlayer> players;
	private ArrayList<Stone> board;
	
	public Game(){
		id++;
		board = new ArrayList<Stone>();
		players = new ArrayList<IPlayer>();
	}
	
	public ArrayList<Stone> getBoard() {
		return board;
	}
	
	public ArrayList<IPlayer> getPlayers() {
		return players;
	}
	
	static{
		id = 1;
	}
}
