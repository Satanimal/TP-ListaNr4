package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Logic.Player;
import Models.BaseSocketModel;
import Models.JoinGameModel;
import Models.ListOfGamesModel;
import Models.PlayerSide;

public class LobbyCallsThread implements Runnable{
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private String playerName;
	
	public LobbyCallsThread(
			ObjectInputStream objectInputStream, 
			ObjectOutputStream objectOutputStream,
			String playerName){
		this.objectInputStream = objectInputStream;
		this.objectOutputStream = objectOutputStream;
		this.playerName = playerName;
		Server.listOfPlayersNames.add(playerName);
	}
	
	public void run() {
		try{
			while(true){
				BaseSocketModel message = (BaseSocketModel)objectInputStream.readObject();
				
				switch(message.message){
					case "getListOfGames" : getListOfGames(); break;
					case "createGame" : createGame(); break;
					case "joinGame" : joinGame(((JoinGameModel)message).gameId); break;
					case "joinGameWithAI" : joinGameWithAI(); break;
				}
			}
		}
		catch(ClassNotFoundException ex){
			
		}
		catch(IOException ex){
			
		}
	}

	private void joinGameWithAI() {
		
	}

	private void joinGame(int gameId) {
		Server.AddPlayerToTheGame(gameId, playerName);
	}

	private void createGame() {
		
	}

	private void getListOfGames() {
		ListOfGamesModel model = new ListOfGamesModel("listOfGames", Server.listOfGames);
		try {
			objectOutputStream.writeObject(model);
		} catch (IOException ex) {
			
		}
	}

}
