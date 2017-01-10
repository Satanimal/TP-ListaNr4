package Graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	private final int screenWidth = screenSize.width;
	private final int screenHeight = screenSize.height;
	private JButton button;
	private JLabel label;
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public MainFrame(ObjectInputStream input, ObjectOutputStream output){
		super();
		this.input = input;
		this.output = output;
		setVisible(true);
		setSize((2*screenWidth)/3, (2*screenHeight)/3);
		setTitle("Duo Heidi and Guderian, presents: ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
