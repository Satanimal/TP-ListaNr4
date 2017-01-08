package Server;

import java.io.IOException;
import java.net.Socket;

public class ConnectionLoopThread implements Runnable{
	public ConnectionLoopThread(){
		
	}
	
	public void run() {
		try{
			while (true) {
				Socket socket = Server.listener.accept();
	            Server.connections.add(socket);
	            
	        }
		}
		catch(IOException ex){
			
		}
	}

}
