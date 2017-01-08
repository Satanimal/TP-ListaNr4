package Graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LobbyFrame extends JFrame{
	private ObjectInputStream inputStream;
	private ObjectOutputStream OutputStream;
	private JButton JoinButton;
	private JButton CreateGameButton;
	private JButton CreateBotGame;
	private Container Panel;
	private JPanel GameListArea;
	private JPanel ButtonPanel;
	private JScrollPane ScrollPane;
	public LobbyFrame(ObjectInputStream inputStream, ObjectOutputStream OutputStream){
		super();
		this.inputStream = inputStream;
		this.OutputStream = OutputStream;
		
		Panel = getContentPane();
		Panel.setLayout(new BorderLayout());
		
		ScrollPane = new JScrollPane();
		try {
			inputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Panele
		GameListArea = new JPanel();
		GameListArea.setBounds(1, 1, 400, 300);
		GameListArea.add(ScrollPane);
		Panel.add(GameListArea, BorderLayout.CENTER);
		
		ButtonPanel = new JPanel();
		Panel.add(ButtonPanel, BorderLayout.PAGE_END);
		
		//Buttony
		JoinButton = new JButton("Join Grame");
		ButtonPanel.add(JoinButton);
		
		CreateGameButton = new JButton("Create Game");
		ButtonPanel.add(CreateGameButton);
		
		CreateBotGame = new JButton("Bot Game");
		ButtonPanel.add(CreateBotGame);
		
		
		
		
		setTitle("DDDDupa");
		setResizable(false);
		pack();
	}
}
