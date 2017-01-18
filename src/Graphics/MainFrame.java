package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame{

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	private final int screenWidth = screenSize.width;
	private final int screenHeight = screenSize.height;
	private JTextArea messageCointainer;
	private Container panel;
	private JScrollPane scroll;
	private Board board;
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public MainFrame(ObjectInputStream input, ObjectOutputStream output){
		super();
		this.input = input;
		this.output = output;
		setLayout(new FlowLayout(0));
		
		board = new Board(((2*screenHeight)/3) , ((2*screenHeight)/3));
		board.setPreferredSize(new Dimension(((2*screenHeight)/3), (2*screenHeight)/3));
		add(board, FlowLayout.LEFT);
		
		messageCointainer = new JTextArea();
		messageCointainer.setFont(new Font("SansSerif", Font.PLAIN , 12));
		messageCointainer.setForeground(Color.DARK_GRAY);
		messageCointainer.setPreferredSize(new Dimension(screenWidth - 2*board.getWidth() ,(2*screenHeight)/3 +50));
		messageCointainer.setText("");
		add(messageCointainer, FlowLayout.CENTER);

		
		
		
		setVisible(true);
		setSize((2*screenWidth)/3, (2*screenHeight)/3 +50);
		setTitle("Duo Heidi and Guderian, presents: ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
}
