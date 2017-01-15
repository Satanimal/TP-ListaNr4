package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import Logic.Game;
import Logic.IPlayer;
import Models.PlayerSide;


public class Server{
	private static ArrayList<Socket> connections = new ArrayList<Socket>();
	private static ArrayList<Game> listOfGames = new ArrayList<Game>();
	private static ArrayList<String> listOfPlayersNames = new ArrayList<String>();
	public static ServerSocket listener;
	
	
    public static void main(String[] args) throws IOException {
        listener = new ServerSocket(9090);
        
        //Start listening for incoming connections
        new Thread(new ConnectionLoopThread()).start();
    }
    
    
    public static void AddPlayerToTheGame(int gameId, IPlayer player){
    	
    	Game game = listOfGames.get(gameId);
    	game.getPlayers().add(player);
    	
    	if(game.getPlayers().size() == 2)
    		game.StartGame();
    }
    
    
    public static int CreateGame(){
    	Game game = new Game();
    	listOfGames.add(game);
    	return game.getId();
    }
    
    
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