package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * W¹tek odpalony przy starcie serwera.
 * Nas³uchuje przychodz¹cych po³¹czeñ od klientów.
 */
public class ConnectionLoopThread implements Runnable{
	public ConnectionLoopThread(){
		
	}
	
	public void run() {
		try{
			while (true) {
				Socket clientSocket = Server.listener.accept();
	            Server.GetConnections().add(clientSocket);
	            
	    	    OutputStream outputStream = clientSocket.getOutputStream();
	    	    InputStream inputStream = clientSocket.getInputStream();
	    	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    	    
	    	    String playerName;
	    	    while(true){
	    	    	playerName = objectInputStream.readUTF();
	    	    	
	    	    	if(!isAlreadyInUse(playerName)){
	    	    		objectOutputStream.writeUTF("validName");
	    	    		objectOutputStream.flush();
	    	    		break;
	    	    	}
	    	    	else{
	    	    		objectOutputStream.writeUTF("invalidOrAlreadyUsedName");
	    	    		objectOutputStream.flush();
	    	    		continue;
	    	    	}
	    	    }
	    	    objectOutputStream.reset();
	            new Thread(new LobbyCallsThread(objectInputStream, objectOutputStream, playerName)).start();
	        }
		}
		catch(IOException ex){
			
		}
	}

	/**
	 * Sprawdza, czy imiê gracza jest ju¿ na liœcie u¿ywanych nicków
	 * @param name Nazwa gracza
	 * @return
	 */
	private boolean isAlreadyInUse(String name) {
		return Server.GetListOfPlayersNames().contains(name);
	}

}
