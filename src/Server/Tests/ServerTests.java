package Server.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Logic.Game;
import Logic.Player;
import Server.Server;

public class ServerTests {

	@Test
	public void testAddPlayerToTheGame() {
		Game game = new Game();
		Server.GetListOfGames().add(game);
		
		Server.AddPlayerToTheGame(0, new Player("player1", null, null));
		
		assertEquals(1, Server.GetListOfGames().get(0).getPlayers().size());
	}

	@Test
	public void testCreateGame(){
		Server.CreateGame();
		
		assertEquals(Server.GetListOfGames().size(), 1);
	}
	
	@Test
	public void testSetPlayerSides(){
		Game game = new Game();
		Server.GetListOfGames().add(game);
		game.getPlayers().add(new Player("player1", null,null));
		game.getPlayers().add(new Player("player2", null,null));
		
		Server.SetPlayerSides(1);
		
		assertNotNull(game.getPlayers().get(0).GetPlayerSide());
		assertNotNull(game.getPlayers().get(1).GetPlayerSide());
		assertNotSame(game.getPlayers().get(0).GetPlayerSide(), game.getPlayers().get(1).GetPlayerSide());
	}
	
	
}
