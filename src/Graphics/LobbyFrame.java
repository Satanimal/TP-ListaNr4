package Graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Graphics.ActionListeners.BotGameListener;
import Graphics.ActionListeners.CreateGameListener;
import Graphics.ActionListeners.JoinGameListener;
import Logic.Game;
import Models.BaseSocketModel;
import Models.ListOfGamesModel;

public class LobbyFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private JButton CreateGameButton;
	private JButton CreateBotGame;
	private Container Panel;
	private JPanel GameListArea;
	private JPanel ButtonPanel;
	private JScrollPane scrollPane;
	private ListOfGamesModel listOfGames;
	private ArrayList<Game> list;
	private JButton joinGame;
	public LobbyFrame(ObjectInputStream inputStream, ObjectOutputStream outputStream){
		super();
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		Panel = getContentPane();
		Panel.setLayout(new BorderLayout());
		
		GameListArea = new JPanel();
		GameListArea.setBounds(0, 0, 400, 300);
		GameListArea.setLayout(new GridLayout(100,2));
		Panel.add(GameListArea, BorderLayout.CENTER);
		
		try {
			this.outputStream.reset();
			this.outputStream.writeObject(new BaseSocketModel("getListOfGames"));
			listOfGames = (ListOfGamesModel) this.inputStream.readObject();
			list = listOfGames.listOfGames;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		for(Game game : list){
			if(game.getPlayers().size()!= 2){
				joinGame = new JButton(game.getPlayers().get(0).GetPlayerName());
				joinGame.addActionListener(new JoinGameListener(this.inputStream, this.outputStream, game, LobbyFrame.this));
				GameListArea.add(joinGame);
			}
		}
		
		scrollPane = new JScrollPane(GameListArea);
		scrollPane.setBounds(0,0, 400, 200);

		Panel.add(scrollPane);

		ButtonPanel = new JPanel();
		Panel.add(ButtonPanel, BorderLayout.PAGE_END);

		CreateGameButton = new JButton("Create Game");
		CreateGameButton.addActionListener(new CreateGameListener(this.inputStream, this.outputStream, LobbyFrame.this));
		ButtonPanel.add(CreateGameButton);
		
		CreateBotGame = new JButton("Bot Game");
		CreateBotGame.addActionListener(new BotGameListener(this.inputStream, this.outputStream, LobbyFrame.this));
		ButtonPanel.add(CreateBotGame);
		
		setBounds(100, 100, 400, 400);
		setTitle("Operation Valkiria");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
