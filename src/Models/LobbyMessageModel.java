package Models;

/**
 * Model wysy³any przez klienta do serwera w celu przekazania informacji na temat wyboru trybu gry.
 * Zawiera nazwê gracza podejmuj¹cego akcjê.
 */
public class LobbyMessageModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	String playerName;
	
	public LobbyMessageModel(String message, String playerName) {
		super(message);
		this.playerName = playerName;
	}

}
