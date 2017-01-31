package Models;

/**
 * Model wysy�any z klienta do serwera w celu do��czenia do gry.
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
