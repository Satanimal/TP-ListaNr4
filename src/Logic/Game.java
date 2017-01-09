package Logic;

import java.util.ArrayList;

import Models.Stone;
import Server.Server;

public class Game{
	private static int generalId;
	private int id;
	private ArrayList<IPlayer> players;
	private ArrayList<Stone> board;
	
	public Game(){
		id = generalId;
		generalId++;
		board = new ArrayList<Stone>();
		players = new ArrayList<IPlayer>();
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
	
	public void StartGame(){
		Server.SetPlayerSides(id);
		
	}
	
	static{
		generalId = 0;
	}
}
