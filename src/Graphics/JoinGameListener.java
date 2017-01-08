package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JoinGameListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	public JoinGameListener(ObjectInputStream input, ObjectOutputStream output){
		this.input = input;
		this.output = output;
	}
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
