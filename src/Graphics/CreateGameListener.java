package Graphics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Models.BaseSocketModel;

public class CreateGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private LobbyFrame frame;
	public CreateGameListener(ObjectInputStream input, ObjectOutputStream output, LobbyFrame frame){
		this.input = input;
		this.output = output;
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent arg0) {
		try {
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
