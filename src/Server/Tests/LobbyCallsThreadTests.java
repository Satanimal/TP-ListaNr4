package Server.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Logic.Game;
import Server.LobbyCallsThread;
import Server.Server;

public class LobbyCallsThreadTests {
	private LobbyCallsThread lobbyCalls;
	
	@Before
	public void initialize(){
		lobbyCalls = new LobbyCallsThread(null, null, "player");
	}
	
	@Test
	public void testJoinGame(){
		Game game = new Game();
		Server.GetListOfGames().add(game);
		lobbyCalls.joinGame(0);
		
		assertEquals(1, Server.GetListOfGames().get(0).getPlayers().size());
	}

	@Test
	public void testCreateGame(){
		int gamesAmount = Server.GetListOfGames().size();
		
		lobbyCalls.createGame();
		lobbyCalls.createGame();
		lobbyCalls.createGame();
		
		assertEquals(gamesAmount + 3, Server.GetListOfGames().size());
	}
}
