package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Models.BaseSocketModel;

public class CreateGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	public CreateGameListener(ObjectInputStream input, ObjectOutputStream output){
		this.input = input;
		this.output = output;
	}
	public void actionPerformed(ActionEvent arg0) {
		try {
			output.writeObject(new BaseSocketModel("createGame"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
