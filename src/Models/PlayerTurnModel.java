package Models;

import java.util.ArrayList;

public class PlayerTurnModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Stone> board;

	public PlayerTurnModel(String message, ArrayList<Stone> board) {
		super(message);
		this.board = board;
	}

}
