package Graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private ButtonGroup gameList;
	private JRadioButton multipleButton;
	public LobbyFrame(ObjectInputStream inputStream, ObjectOutputStream outputStream){
		super();
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		Panel = getContentPane();
		Panel.setLayout(new BorderLayout());
		gameList = new ButtonGroup();
		ScrollPane = new JScrollPane();
		ScrollPane.setBounds(1, 1, 250, 250);
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
			if(game.getPlayers().size()!= 2){
				multipleButton = new JRadioButton(game.getPlayers().toString());
				multipleButton.addActionListener(new JoinGameListener(inputStream, outputStream, game));
				gameList.add(multipleButton);
				ScrollPane.add(multipleButton);
			}
			else
			{}
		}

		GameListArea = new JPanel();
		GameListArea.setBounds(1, 1, 400, 300);
		GameListArea.add(ScrollPane);
		Panel.add(GameListArea, BorderLayout.CENTER);
		
		ButtonPanel = new JPanel();
		Panel.add(ButtonPanel, BorderLayout.PAGE_END);

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
		repaint();
	}
}
