package Graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Logic.Game;
import Models.BaseSocketModel;
import Models.ListOfGamesModel;

public class LobbyFrame extends JFrame{
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private JButton JoinButton;
	private JButton CreateGameButton;
	private JButton CreateBotGame;
	private Container Panel;
	private JPanel GameListArea;
	private JPanel ButtonPanel;
	private JScrollPane ScrollPane;
	private ListOfGamesModel listOfGames;
	private ArrayList<Game> list;
	public LobbyFrame(ObjectInputStream inputStream, ObjectOutputStream outputStream){
		super();
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		
		Panel = getContentPane();
		Panel.setLayout(new BorderLayout());
		
		ScrollPane = new JScrollPane();
			try {
				outputStream.writeObject(new BaseSocketModel("getListOfGames"));
				listOfGames = (ListOfGamesModel) inputStream.readObject();
				list = listOfGames.listOfGames;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		for(Game game : list){
			GameListArea.add(new JCheckBox(game.getBoard().toString()));
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
		JoinButton.addActionListener(new JoinGameListener(inputStream, outputStream));
		ButtonPanel.add(JoinButton);
		
		CreateGameButton = new JButton("Create Game");
		CreateGameButton.addActionListener(new CreateGameListener(inputStream, outputStream));
		ButtonPanel.add(CreateGameButton);
		
		CreateBotGame = new JButton("Bot Game");
		CreateBotGame.addActionListener(new BotGameListener(inputStream, outputStream));
		ButtonPanel.add(CreateBotGame);
		
		setBounds(100, 100, 400, 400);
		setTitle("Operation Valkiria");
		setResizable(false);
		pack();
	}
}
