package Models;

public class LobbyMessageModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	String playerName;
	
	public LobbyMessageModel(String message, String playerName) {
		super(message);
		this.playerName = playerName;
	}

}
