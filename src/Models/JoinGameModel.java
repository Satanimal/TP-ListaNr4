package Models;

public class JoinGameModel extends BaseSocketModel{
	public int gameId;
	
	public JoinGameModel(String message, int gameId) {
		super(message);
		this.gameId = gameId;
	}

}
