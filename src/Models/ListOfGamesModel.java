package Models;

import java.util.ArrayList;

import Logic.Game;

public class ListOfGamesModel extends BaseSocketModel{
	ArrayList<Game> listOfGames;
	public ListOfGamesModel(String message, ArrayList<Game> listOfGames) {
		super(message);
		this.listOfGames = listOfGames;
	}
}