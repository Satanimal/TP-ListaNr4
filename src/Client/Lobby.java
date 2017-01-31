package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import Graphics.LobbyFrame;

/**
 * G³ówny program klienta, odpowiadaj¹cy za po³¹czenie z serwerem
 */
public class Lobby{
	public static void main(String[] args) throws IOException {
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a server\n");
	    Socket gameSocket = new Socket(serverAddress, 9090);
	    
	    //Streamy odpowiedzialne za komunikacjê z serwerem
	    OutputStream outputStream = gameSocket.getOutputStream();
	    InputStream inputStream = gameSocket.getInputStream();
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    
	    //Pêtla odpowiedzialna za wprowadzanie nazwy gracza, dopóki nie jest unikalna po stronie serwera
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
