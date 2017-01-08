package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

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
	    
	    InputStream inputStream = gameSocket.getInputStream();
	    OutputStream outputStream = gameSocket.getOutputStream();
	    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    
	    LobbyFrame lobbyFrame = new LobbyFrame(objectInputStream, objectOutputStream);
	}

}
