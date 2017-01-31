package Handlers;

import java.util.ArrayList;

import Models.Stone;

/**
 * Klasa zawieraj¹ca metody odpowiedzialne za logikê gry, oraz sprawdzanie poprawnoœci ruchów graczy
 */
public final class MoveValidationHandler {
	
	/**
	 * Prywatny konstruktor maj¹cy zapewniæ statycznoœœ ca³ej klasy
	 */
	private MoveValidationHandler() {
	}
	
	/**
	 * Podstawowa metoda sprawdzaj¹ca poprawnoœæ ruchu
	 * @param board
	 * @param playerMove
	 * @return
	 */
	public static boolean IsValid(ArrayList<Stone> board, Stone playerMove) {
		if(!IsInRangeOfBoard(playerMove))
			return false;
		
		for(Stone stone : board){
			if(stone.coordinates.equals(playerMove.coordinates))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Sprawdza, czy wspó³rzêdne ruchu nie wykraczaj¹ poza planszê
	 * @param playerMove
	 * @return
	 */
	private static boolean IsInRangeOfBoard(Stone playerMove){
		return playerMove.coordinates.getX() > 0 && playerMove.coordinates.getX() < 20 &&
			   playerMove.coordinates.getY() > 0 && playerMove.coordinates.getY() < 20;
				
	}
}
