package Logic;

import Models.PlayerSide;

public class AIPlayer implements IPlayer{
	private PlayerSide _playerSide;
	
	public AIPlayer(PlayerSide playerSide){
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
