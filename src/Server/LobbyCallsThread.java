package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Logic.AIPlayer;
import Logic.Player;
import Models.BaseSocketModel;
import Models.JoinGameModel;
import Models.ListOfGamesModel;

/**
 * W¹tek odpowiedzialny za nas³uchiwanie przychodz¹cych od po³¹czonego klienta akcji.
 */
public class LobbyCallsThread implements Runnable{
	private Player player;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	/**
	 * Kontruktor
	 * @param objectInputStream Strumieñ wejœcia do komuniakcji z serwerem
	 * @param objectOutputStream Strumieñ wyjœcia do komunikacji z serwerem
	 * @param playerName Nazwa gracza
	 */
	public LobbyCallsThread(
			ObjectInputStream objectInputStream,
			ObjectOutputStream objectOutputStream,
			String playerName){
		this.input = objectInputStream;
		this.output = objectOutputStream;
		
		Server.GetListOfPlayersNames().add(playerName);
		player = new Player(playerName, objectInputStream, objectOutputStream);
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

	/**
	 * Rozpoczyna now¹ grê z botem
	 */
	private void joinGameWithAI() {
		int id = Server.CreateGame();
		Server.AddPlayerToTheGame(id, player);
		AIPlayer bot = new AIPlayer("Artificial Intelligence");
		Server.AddPlayerToTheGame(id, bot);
	}

	/**
	 * Do³¹cza gracza do gry o wskazanym ID
	 * @param gameId ID gry docelowej
	 */
	private void joinGame(int gameId) {
		Server.AddPlayerToTheGame(gameId, player);
	}

	/**
	 * Tworzy now¹ grê i dodaje gracza
	 */
	private void createGame() {
		int id = Server.CreateGame();
		Server.AddPlayerToTheGame(id, player);
	}

	/**
	 * Wysy³a do klienta listê aktualnie dostepnych gier
	 */
	private void getListOfGames() {
		ListOfGamesModel model = new ListOfGamesModel("listOfGames", Server.GetListOfGames());
		try {
			output.reset();
			output.writeObject(model);
			output.flush();
		} catch (IOException ex) {
			
		}
	}

}
