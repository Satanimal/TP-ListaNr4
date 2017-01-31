package Server.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Logic.Game;
import Logic.IPlayer;
import Logic.Player;
import Models.PlayerSide;
import Server.GameLoopThread;

public class GameLoopThreadTests {

	@Test
	public void testSwapPlayers() {
		Game game = new Game();
		Player player1 = new Player("player1", null, null);
		player1.SetPlayerSide(PlayerSide.White);
		Player player2 = new Player("player2", null, null);
		player2.SetPlayerSide(PlayerSide.Black);
		game.getPlayers().add(player1);
		game.getPlayers().add(player2);
		GameLoopThread gameLoop = new GameLoopThread(game);
		
		IPlayer playerBeforeSwap = gameLoop.getCurrentPlayer();
		
		gameLoop.swapPlayers();
		
		IPlayer playerAfterSwap = gameLoop.getCurrentPlayer();
		
		assertNotEquals(playerAfterSwap, playerBeforeSwap);
	}

}
