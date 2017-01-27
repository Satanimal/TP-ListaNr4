package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketPermission;

import javax.swing.JOptionPane;

import Graphics.LobbyFrame;

public class Lobby{
	//klasa ladujaca dane z serwera(liste gier) 
	// i wyswietlajaca to w ramce 
	//mozliwosc dolaczenia do gry i start glownego okienka jesli poprawne
	public static void main(String[] args) throws IOException {
		String serverAddress = JOptionPane.showInputDialog(
	            "Enter IP Address of a server\n");
	    Socket gameSocket = new Socket(serverAddress, 9090);
	    SocketPermission p1 = new SocketPermission("localhost:9090", "accept,connect,listen");
	    OutputStream outputStream = gameSocket.getOutputStream();
	    InputStream inputStream = gameSocket.getInputStream();
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    
	    while(true){
	    	String playerName = JOptionPane.showInputDialog("Wprowadz nazwê u¿ytkownika");
	    	objectOutputStream.writeUTF(playerName);
	    	objectOutputStream.flush();
	    	
	    	String response = objectInputStream.readUTF();
	    	if(response.equals("validName")){
	    		break;
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "B³êdna lub u¿ywana nazwa");
	    		continue;
	    	}
	    }
    	objectOutputStream.reset();
	    LobbyFrame lobbyFrame = new LobbyFrame(objectInputStream, objectOutputStream);
	    lobbyFrame.setVisible(true);
	}

}
