package Logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import Models.PlayerSide;

public class Player implements IPlayer, Serializable{

	private static final long serialVersionUID = 1L;
	private PlayerSide playerSide;
	private String playerName;
	
	public Player(String playerName, Socket connection){
		this.playerName = playerName;
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
}
