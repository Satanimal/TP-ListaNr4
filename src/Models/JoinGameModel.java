package Models;

/**
 * Model wysy³any z klienta do serwera w celu do³¹czenia do gry.
 * Zawiera ID gry docelowej.
 */
public class JoinGameModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	public int gameId;
	
	public JoinGameModel(String message, int gameId) {
		super(message);
		this.gameId = gameId;
	}

}
