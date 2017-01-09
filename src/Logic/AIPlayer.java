package Logic;

import Models.PlayerSide;

public class AIPlayer implements IPlayer{
	private PlayerSide playerSide;
	private String playerName;
	
	public AIPlayer(String playerName){
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
	
	public String GetPlayerName() {
		return playerName;
	}
}
