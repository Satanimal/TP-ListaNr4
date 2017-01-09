package Logic;

import java.io.Serializable;
import java.util.ArrayList;

import Models.Stone;
import Server.Server;

public class Game implements Serializable{

	private static final long serialVersionUID = 1L;
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
