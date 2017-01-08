package Graphics_Tests;

import javax.swing.JFrame;

import Graphics.LobbyFrame;
import Graphics.MainFrame;

public class LobbyFrameTest {
	public static void main (String[] args){
		LobbyFrame frame = new LobbyFrame(null, null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame frame2 = new MainFrame();
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
