package Graphics;

import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LobbyFrame extends JFrame{
	private ServerSocket beforeClient;
	private JButton JoinButton;
	private JButton CreateGameButton;
	private JButton CreateBotGame;
	public LobbyFrame(ServerSocket beforeClient){
		super();
		this.beforeClient = beforeClient;
		
	}
}
