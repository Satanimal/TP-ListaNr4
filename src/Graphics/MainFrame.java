package Graphics;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private JButton button;
	private JLabel label;
	
	public MainFrame(){
		setVisible(true);
		setSize((2*screenWidth)/3, (2*screenHeight)/3);
		setTitle("Duo Heidi and Guderian");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
