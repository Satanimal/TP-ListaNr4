package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Logic.AIPlayer;
import Logic.Player;
import Models.BaseSocketModel;
import Models.JoinGameModel;
import Models.ListOfGamesModel;

public class LobbyCallsThread implements Runnable{
	private Player player;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public LobbyCallsThread(
			ObjectInputStream objectInputStream,
			ObjectOutputStream objectOutputStream,
			String playerName,
			Socket connection){
		this.input = objectInputStream;
		this.output = objectOutputStream;
		Server.GetListOfPlayersNames().add(playerName);
		player = new Player(playerName, connection);
	}
	
	public void run() {
		try{
			while(true){
				BaseSocketModel message = (BaseSocketModel)input.readObject();
				
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
		int id = Server.CreateGame();
		Server.AddPlayerToTheGame(id, player);
		AIPlayer bot = new AIPlayer("Artificial Intelligence");
		Server.AddPlayerToTheGame(id, bot);
	}

	private void joinGame(int gameId) {
		Server.AddPlayerToTheGame(gameId, player);
	}

	private void createGame() {
		int id = Server.CreateGame();
		Server.AddPlayerToTheGame(id, player);
	}

	private void getListOfGames() {
		ListOfGamesModel model = new ListOfGamesModel("listOfGames", Server.GetListOfGames());
		try {
			output.writeObject(model);
			output.flush();
		} catch (IOException ex) {
			
		}
	}

}
