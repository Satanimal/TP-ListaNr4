package Logic;

import Models.PlayerSide;

public class Player implements IPlayer{
	private PlayerSide _playerSide;
	
	public Player(PlayerSide playerSide){
		_playerSide = playerSide;
	}
	
	public void MakeMove() {
		// TODO Auto-generated method stub
		
	}

	public void WaitForAction() {
		// TODO Auto-generated method stub
		
	}

	public PlayerSide GetPlayerSide() {
		return _playerSide;
	}
	
}
