package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class BeforeClient{
	//klasa ladujaca dane z serwera(liste gier) 
	// i wyswietlajaca to w ramce 
	//mozliwosc dolaczenia do gry i start glownego okienka jesli poprawne
	public static void main(String[] args) {
		String serverAddress = JOptionPane.showInputDialog(
	            "Enter IP Address of a machine that is\n" +
	            "running the date service on port 9090:");
	        Socket s = new Socket(serverAddress, 9090);
	        BufferedReader input =
	            new BufferedReader(new InputStreamReader(s.getInputStream()));
	        String answer = input.readLine();
	        JOptionPane.showMessageDialog(null, answer);
	        System.exit(0);

	}

}
