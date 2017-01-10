package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import Logic.Game;
import Models.JoinGameModel;

public class JoinGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Game game;
	private LobbyFrame frame;
	public JoinGameListener(ObjectInputStream input, ObjectOutputStream output, Game game, LobbyFrame frame){
		this.input = input;
		this.output = output;
		this.game = game;
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			output.writeObject(new JoinGameModel("joinGame", game.getId() ));
			frame.setVisible(false);
			MainFrame frame = new MainFrame(input,output);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
