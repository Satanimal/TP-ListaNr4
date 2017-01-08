package Logic;

import Models.PlayerSide;

public class Player implements IPlayer{
	private PlayerSide playerSide;
	private String playerName; 
	
	public Player(PlayerSide playerSide, String playerName){
		this.playerSide = playerSide;
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
	
	public String GetPlayerName(){
		return playerName;
	}
}
