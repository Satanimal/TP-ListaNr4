package Models;

public class JoinGameModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	public int gameId;
	
	public JoinGameModel(String message, int gameId) {
		super(message);
		this.gameId = gameId;
	}

}
