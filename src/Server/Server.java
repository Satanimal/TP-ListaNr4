package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import Logic.Game;
import Logic.Player;
import Models.PlayerSide;


public class Server{
	public static ArrayList<Socket> connections = new ArrayList<Socket>();
	public static ArrayList<Game> listOfGames = new ArrayList<Game>();
	public static ArrayList<String> listOfPlayersNames = new ArrayList<String>();
	public static ServerSocket listener;
	
	
    public static void main(String[] args) throws IOException {
        listener = new ServerSocket(9090);
        
        //Start listening for incoming connections
        new Thread(new ConnectionLoopThread()).start();
    }
    
    
    public static void AddPlayerToTheGame(int gameId, String playerName){
    	Game game = listOfGames.get(gameId);
    	Player player = new Player(GetPlayerSide(game), playerName);
    	game.getPlayers().add(player);
    }
    
    
    private static PlayerSide GetPlayerSide(Game game){	
    	PlayerSide result;
    	
    	if(game.getPlayers().size() == 0){
        	Random rand = new Random();
        	if(rand.nextInt(2) == 0)
        		result = PlayerSide.White;
        	else
        		result = PlayerSide.Black; 
    	}
    	else{
    		if(game.getPlayers().get(0).GetPlayerSide().equals(PlayerSide.Black))
    			result = PlayerSide.White;
    		else
    			result = PlayerSide.Black;
    	}
    	
    	return result;
    }
}