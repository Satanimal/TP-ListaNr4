package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Logic.Game;


public class Server{
	public static ArrayList<Socket> connections = new ArrayList<Socket>();
	public static ArrayList<Game> listOfGames = new ArrayList<Game>();
	public static ServerSocket listener;
    public static void main(String[] args) throws IOException {
        listener = new ServerSocket(9090);
        
        //Start listening for incoming connections
        new Thread(new ConnectionLoopThread()).start();
        //infinite loop to stop server executio
        while(true){
        }
    }
    
    public static void AddPlayerToTheGame(int gameId, String playerName){
    	Game game = listOfGames.get(gameId);
    }
}