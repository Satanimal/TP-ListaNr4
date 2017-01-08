package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server{
	public static ArrayList<Socket> connections = new ArrayList<Socket>();
	public static ServerSocket listener;
    public static void main(String[] args) throws IOException {
        listener = new ServerSocket(9090);
        
	    /*InputStream inputStream = gameSocket.getInputStream();
	    OutputStream outputStream = gameSocket.getOutputStream();
	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);*/
        
        //Start listening for incoming connections
        new Thread(new ConnectionLoopThread()).start();
        //infinite loop to stop server executio
        while(true){
        }
    }
}