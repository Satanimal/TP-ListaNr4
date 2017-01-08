package Graphics;

import java.net.ServerSocket;

import javax.swing.JFrame;

import Client.BeforeClient;

public class BeforeClientFrame extends JFrame{
	private ServerSocket beforeClient;
	
	public BeforeClientFrame(ServerSocket beforeClient){
		this.beforeClient = beforeClient;
	}

}
