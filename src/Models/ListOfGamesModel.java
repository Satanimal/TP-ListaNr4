package Models;

import java.io.Serializable;
import java.util.ArrayList;

import Logic.Game;

/**
 * Model wykorzystywany do przesy�ania informacji na temat istniej�cych gier.
 */
public class ListOfGamesModel extends BaseSocketModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public  ArrayList<Game> listOfGames;
	public ListOfGamesModel(String message, ArrayList<Game> listOfGames) {
		super(message);
		this.listOfGames = listOfGames;
	}
}
