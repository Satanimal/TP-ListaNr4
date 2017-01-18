package Graphics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import Models.BaseSocketModel;

public class BotGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private LobbyFrame frame;
	public BotGameListener(ObjectInputStream input, ObjectOutputStream output, LobbyFrame frame){
		this.input = input;
		this.output = output;
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			output.writeObject(new BaseSocketModel("joinGameWithAI"));
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
