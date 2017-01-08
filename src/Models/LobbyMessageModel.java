package Models;

public class LobbyMessageModel extends BaseSocketModel{
	String playerName;
	
	public LobbyMessageModel(String message, String playerName) {
		super(message);
		this.playerName = playerName;
	}

}
