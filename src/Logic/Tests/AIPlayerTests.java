package Logic.Tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import Logic.AIPlayer;
import Models.Stone;

public class AIPlayerTests {

	@Test
	public void test() {
		AIPlayer bot = new AIPlayer("bot");
		ArrayList<Stone> board = new ArrayList<Stone>();
		
		assertEquals(0, board.size());
		
		try {
			bot.MakeMove(board);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(1, board.size());
	}

}
