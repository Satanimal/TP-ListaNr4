package Logic;

import java.io.IOException;
import java.util.ArrayList;

import Models.PlayerSide;
import Models.Stone;

public interface IPlayer {
	public void MakeMove(ArrayList<Stone> board) throws ClassNotFoundException, IOException;
	public void WaitForAction(ArrayList<Stone> board) throws IOException;
	public PlayerSide GetPlayerSide();
	public void SetPlayerSide(PlayerSide playerSide);
	public String GetPlayerName();
}
