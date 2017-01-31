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
 * G��wny program klienta, odpowiadaj�cy za po��czenie z serwerem
 */
public class Lobby{
	public static void main(String[] args) throws IOException {
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a server\n");
	    Socket gameSocket = new Socket(serverAddress, 9090);
	    
	    //Streamy odpowiedzialne za komunikacj� z serwerem
	    OutputStream outputStream = gameSocket.getOutputStream();
	    InputStream inputStream = gameSocket.getInputStream();
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    
	    //P�tla odpowiedzialna za wprowadzanie nazwy gracza, dop�ki nie jest unikalna po stronie serwera
	    while(true){
	    	String playerName = JOptionPane.showInputDialog("Wprowadz nazw� u�ytkownika");
	    	objectOutputStream.writeUTF(playerName);
	    	objectOutputStream.flush();
	    	
	    	String response = objectInputStream.readUTF();
	    	if(response.equals("validName")){
	    		break;
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "B��dna lub u�ywana nazwa");
	    		continue;
	    	}
	    }
	    
    	objectOutputStream.reset();
	    LobbyFrame lobbyFrame = new LobbyFrame(objectInputStream, objectOutputStream);
	    lobbyFrame.setVisible(true);
	}

}
