package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Graphics.ActionListeners.SurrenderActionListener;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	private final int screenWidth = screenSize.width;
	private final int screenHeight = screenSize.height;
	private JTextArea messageCointainer;
	private Board board;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private JButton surrenderButton;
	/**
	 * G³ówny Frame reprezentuj¹cy okno gry
	 * @param input Strumieñ wejœcia do komuniakcji z serwerem
	 * @param output Strumieñ wyjœcia do komunikacji z serwerem
	 */
	public MainFrame(ObjectInputStream input, ObjectOutputStream output){
		super();
		this.input = input;
		this.output = output;
		setLayout(new FlowLayout(0));
		messageCointainer = new JTextArea();
		board = new Board(((2*screenHeight)/3) , ((2*screenHeight)/3), this.output, this.input, messageCointainer);
		messageCointainer.setFont(new Font("SansSerif", Font.PLAIN , 12));
		messageCointainer.setForeground(Color.DARK_GRAY);
		messageCointainer.setPreferredSize(new Dimension(screenWidth - 2*board.getWidth() ,(2*screenHeight)/3 +50));
		messageCointainer.setText("");
		messageCointainer.setBorder( new TitledBorder ( new EtchedBorder (), "" ) );
		surrenderButton = new JButton("Poddaj siê");
		surrenderButton.addActionListener(new SurrenderActionListener());
		
		board.setPreferredSize(new Dimension(((2*screenHeight)/3), (2*screenHeight)/3));
		add(board, FlowLayout.LEFT);
		add(messageCointainer, FlowLayout.CENTER);
		add(surrenderButton);
		setVisible(true);
		setSize((2*screenWidth)/3, (2*screenHeight)/3 +50);
		setTitle("Duo Heidi and Guderian, presents: ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
}
