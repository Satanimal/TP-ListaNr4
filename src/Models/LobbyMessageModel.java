package Models;

/**
 * Model wysy�any przez klienta do serwera w celu przekazania informacji na temat wyboru trybu gry.
 * Zawiera nazw� gracza podejmuj�cego akcj�.
 */
public class LobbyMessageModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	String playerName;
	
	public LobbyMessageModel(String message, String playerName) {
		super(message);
		this.playerName = playerName;
	}

}
