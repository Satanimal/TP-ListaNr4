package Logic;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Handlers.MoveValidationHandler;
import Models.PlayerSide;
import Models.Stone;

public class AIPlayer implements IPlayer{
	private PlayerSide playerSide;
	private String playerName;
	
	public AIPlayer(String playerName){
		this.playerName = playerName;
	}
	
	public void MakeMove(ArrayList<Stone> board) throws ClassNotFoundException, IOException {
		Stone move = null;
		Random rand = new Random();
		
		while(true){
			move = new Stone(new Point2D.Double(rand.nextInt(19), rand.nextInt(19)));
			if(!MoveValidationHandler.IsValid(board, move))
				continue;
			
			move.color = playerSide;
			board.add(move);
			break;
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void WaitForAction(ArrayList<Stone> board) {
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
