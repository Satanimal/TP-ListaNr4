package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.Random;
import Logic.Game;
import Logic.IPlayer;
import Models.PlayerSide;

/**
 * G��wny program serwera
 */
public class Server{
	private static ArrayList<Socket> connections = new ArrayList<Socket>();
	private static ArrayList<Game> listOfGames = new ArrayList<Game>();
	private static ArrayList<String> listOfPlayersNames = new ArrayList<String>();
	public static ServerSocket listener;
	
	
    public static void main(String[] args) throws IOException {
        listener = new ServerSocket(9090);
        SocketPermission p1 = new SocketPermission("localhost:9090", "accept,connect,listen");
        //Start listening for incoming connections
        new Thread(new ConnectionLoopThread()).start();
    }
    
    /**
     * Dodaje gracza do gry o podanym ID
     * @param gameId ID gry docelowej
     * @param player Nazwa do��czaj�cego gracza
     */
    public static void AddPlayerToTheGame(int gameId, IPlayer player){
    	
    	Game game = listOfGames.get(gameId);
    	game.getPlayers().add(player);
    	
    	if(game.getPlayers().size() == 2)
    		game.StartGame();
    }
    
    /**
     * Tworzy now� gr�
     * @return Zwraca ID utworzonej gry
     */
    public static int CreateGame(){
    	Game game = new Game();
    	listOfGames.add(game);
    	return game.getId();
    }
    
    /**
     * Dla wskazanej przez ID gry, ustawia z losowym prawdopodobie�stwem strony graczy
     * @param gameId Id gry
     */
    public static void SetPlayerSides(int gameId){	
    	Game game = listOfGames.get(gameId);
    	if(game.getPlayers().size() != 2) return;
    	
    	Random rand = new Random();
    	int result = rand.nextInt(2);
    	
    	if(result == 0){
        	game.getPlayers().get(0).SetPlayerSide(PlayerSide.White);
        	game.getPlayers().get(1).SetPlayerSide(PlayerSide.Black);
    	}
    	else{
        	game.getPlayers().get(1).SetPlayerSide(PlayerSide.White);
        	game.getPlayers().get(0).SetPlayerSide(PlayerSide.Black);
    	}
    }


    
    
	public static ArrayList<Socket> GetConnections() {
		return connections;
	}

	public static ArrayList<String> GetListOfPlayersNames() {
		return listOfPlayersNames;
	}
	
	public static ArrayList<Game> GetListOfGames(){
		return listOfGames;
	}

}