package Logic;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import Models.PlayerSide;
import Models.Stone;

/**
 * Interfejs implementowany przez AIPlayer, oraz Player
 */
public interface IPlayer {
	public void MakeMove(ArrayList<Stone> board) throws ClassNotFoundException, IOException, SocketException;
	public void WaitForAction(ArrayList<Stone> board) throws IOException, ClassNotFoundException, SocketException;
	public PlayerSide GetPlayerSide();
	public void SetPlayerSide(PlayerSide playerSide);
	public String GetPlayerName();
}
