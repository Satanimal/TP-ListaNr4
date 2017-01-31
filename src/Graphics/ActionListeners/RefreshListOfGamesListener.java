package Graphics.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Graphics.LobbyFrame;
import Models.BaseSocketModel;
import Models.ListOfGamesModel;

public class RefreshListOfGamesListener implements ActionListener{
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private LobbyFrame frame;
	public RefreshListOfGamesListener(ObjectInputStream input, ObjectOutputStream output, LobbyFrame frame){
		this.input = input;
		this.output = output;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			output.writeObject(new BaseSocketModel("getListOfGames"));
			ListOfGamesModel model = (ListOfGamesModel) input.readObject();
			frame.addGamesToTheList(model.listOfGames);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
