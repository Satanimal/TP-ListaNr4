package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class BoxListener implements ActionListener{
	private JScrollPane scrollPane;
	private int componentCounter;
	public BoxListener(JScrollPane scrollPane){
		this.scrollPane = scrollPane;
		componentCounter = scrollPane.getComponentCount();
		for(int i=0; i<componentCounter; i++){
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
