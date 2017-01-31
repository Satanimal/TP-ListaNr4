package Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Logic.Game;
import Logic.IPlayer;
import Logic.Player;
import Models.PlayerSide;
import Models.PlayerTurnModel;

/**
 * W¹tek odpowiedzialny za rozgrywkê.
 * Zawiera nieskoñczon¹ pêtlê, w której gracze na przemian podejmuj¹ akcje
 */
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
				oppositePlayer.WaitForAction(game.getBoard());
				currentPlayer.MakeMove(game.getBoard());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			catch(IOException e){
				IPlayer playerToInform = null;
				for(StackTraceElement element : e.getStackTrace()){
					if(element.getMethodName().equals("MakeMove")){
						playerToInform = oppositePlayer;
						break;
					}
					if(element.getMethodName().equals("WaitForAction")){
						playerToInform = currentPlayer;
						break;
					}
				}
				
				try {
					((Player) playerToInform).getObjectOutputStream().writeObject(new PlayerTurnModel("playerLeft", null));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				catch(ClassCastException es){
					
				}
				
				Server.GetListOfGames().remove(this);
				return;
			}
			
			swapPlayers();
		}
	}
	
	/**
	 * Ustala gracza aktualnie wykonuj¹cego ruch
	 */
	public void swapPlayers(){
		IPlayer temp = currentPlayer;
		currentPlayer = oppositePlayer;
		oppositePlayer = temp;
	}
	
	public IPlayer getCurrentPlayer(){
		return currentPlayer;
	}
	
	public IPlayer getOpositePlayer(){
		return oppositePlayer;
	}
}
