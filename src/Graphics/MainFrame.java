package Graphics;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	public MainFrame(){
		setVisible(true);
		setSize((2*screenWidth)/3, (2*screenHeight)/3);
		setTitle("Greetings From Dimitri");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
