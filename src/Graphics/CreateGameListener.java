package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CreateGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	public CreateGameListener(ObjectInputStream input, ObjectOutputStream output){
		this.input = input;
		this.output = output;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
