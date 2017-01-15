package Logic;

import java.io.IOException;

import Models.PlayerSide;

public class GameLoopThread implements Runnable{
	private Game game;
	private IPlayer currentPlayer;
	private IPlayer oppositePlayer;
	
	public GameLoopThread(Game game){
		this.game = game;
		currentPlayer = game.getPlayers().get(0).GetPlayerSide() == PlayerSide.White ? game.getPlayers().get(0) : game.getPlayers().get(1);
		oppositePlayer = game.getPlayers().get(0).GetPlayerSide() == PlayerSide.Black ? game.getPlayers().get(0) : game.getPlayers().get(1);
	}
	
	@Override
	public void run() {
		while(true){
			try {
				oppositePlayer.WaitForAction();
				currentPlayer.MakeMove(game.getBoard());
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
			swapPlayers();
		}
	}
	
	private void swapPlayers(){
		IPlayer temp = currentPlayer;
		currentPlayer = oppositePlayer;
		oppositePlayer = temp;
	}
}
