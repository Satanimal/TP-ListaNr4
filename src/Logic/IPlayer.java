package Logic;

import Models.PlayerSide;

public interface IPlayer {
	public void MakeMove();
	public void WaitForAction();
	public PlayerSide GetPlayerSide();
}
