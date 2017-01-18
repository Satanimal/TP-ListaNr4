package Logic;

import java.io.IOException;
import java.util.ArrayList;

import Models.PlayerSide;
import Models.Stone;

public class AIPlayer implements IPlayer{
	private PlayerSide playerSide;
	private String playerName;
	
	public AIPlayer(String playerName){
		this.playerName = playerName;
	}
	
	public void MakeMove(ArrayList<Stone> board) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void WaitForAction(ArrayList<Stone> board) {
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
