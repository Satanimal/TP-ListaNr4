package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionLoopThread implements Runnable{
	public ConnectionLoopThread(){
		
	}
	
	public void run() {
		try{
			while (true) {
				Socket clientSocket = Server.listener.accept();
	            Server.connections.add(clientSocket);
	            
	    	    InputStream inputStream = clientSocket.getInputStream();
	    	    OutputStream outputStream = clientSocket.getOutputStream();
	    	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	            
	    	    //wait for a player name
	    	    String playerName;
	    	    while(true){
	    	    	playerName = objectInputStream.readUTF();
	    	    	
	    	    	if(isValidName(playerName)){
	    	    		break;
	    	    	}
	    	    	else{
	    	    		objectOutputStream.writeUTF("invalidOrAlreadyUsedName");
	    	    		continue;
	    	    	}
	    	    }
	    	    
	            new Thread(new LobbyCallsThread(
	            		objectInputStream, objectOutputStream, playerName)).start();
	        }
		}
		catch(IOException ex){
			
		}
	}

	private boolean isValidName(String name) {
		return false;
	}

}
