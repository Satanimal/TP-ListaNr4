package Models;

import java.util.ArrayList;

/**
 * Model u¿ywany obustronnie w trakcie rozgrywki, w celu przes³ania aktualnego stanu planszy, lub ruchu gracza
 */
public class PlayerTurnModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	public ArrayList<Stone> board;

	public PlayerTurnModel(String message, ArrayList<Stone> board) {
		super(message);
		this.board = board;
	}

}
