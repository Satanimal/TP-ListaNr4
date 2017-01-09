package Logic;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Models.PlayerSide;

public class Player implements IPlayer{
	private PlayerSide playerSide;
	private String playerName;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public Player(String playerName, ObjectInputStream input, ObjectOutputStream output){
		this.playerName = playerName;
		this.input = input;
		this.output = output;
	}
	
	public void MakeMove() {
		// TODO Auto-generated method stub
		
	}

	public void WaitForAction() {
		// TODO Auto-generated method stub
		
	}

	public PlayerSide GetPlayerSide() {
		return playerSide;
	}
	
	public void SetPlayerSide(PlayerSide playerSide){
		this.playerSide = playerSide;
	}
	
	public String GetPlayerName(){
		return playerName;
	}
	
	public ObjectInputStream GetInput(){
		return input;
	}
	
	public ObjectOutputStream GetOutput(){
		return output;
	}
}
