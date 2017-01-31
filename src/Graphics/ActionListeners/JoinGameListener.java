package Graphics.ActionListeners;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Graphics.LobbyFrame;
import Graphics.MainFrame;
import Logic.Game;
import Models.JoinGameModel;

/**
 * ActionListener odpowiedzialny za do³¹czenie do gry
 */
public class JoinGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Game game;
	private LobbyFrame frame;
	
	/**
	 * Konstruktor
	 * @param input
	 * @param output
	 * @param game
	 * @param frame
	 */
	public JoinGameListener(ObjectInputStream input, ObjectOutputStream output, Game game, LobbyFrame frame){
		this.input = input;
		this.output = output;
		this.game = game;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			output.reset();
			output.writeObject(new JoinGameModel("joinGame", game.getId() ));
			frame.setVisible(false);
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run() {
					MainFrame frame = new MainFrame(input,output);	
				}
				
			});
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
