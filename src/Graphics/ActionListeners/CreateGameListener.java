package Graphics.ActionListeners;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Graphics.LobbyFrame;
import Graphics.MainFrame;
import Models.BaseSocketModel;

/**
 * ActionListener odpowiedzialny za utworzenie gry
 */
public class CreateGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private LobbyFrame frame;
	
	/**
	 * Konstruktor
	 * @param input
	 * @param output
	 * @param frame
	 */
	public CreateGameListener(ObjectInputStream input, ObjectOutputStream output, LobbyFrame frame){
		this.input = input;
		this.output = output;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		try {
			output.reset();
			output.writeObject(new BaseSocketModel("createGame"));
			frame.setVisible(false);
			EventQueue.invokeLater(new Runnable(){

				@Override
				public void run() {
					MainFrame frame = new MainFrame(input,output);
				}
				
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
