package Graphics;

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
	public BotGameListener(ObjectInputStream input, ObjectOutputStream output){
		this.input = input;
		this.output = output;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			output.writeObject(new BaseSocketModel("joinGameWithAI"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
}
