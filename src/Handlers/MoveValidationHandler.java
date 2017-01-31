package Handlers;

import java.util.ArrayList;

import Models.Stone;

/**
 * Klasa zawieraj�ca metody odpowiedzialne za logik� gry, oraz sprawdzanie poprawno�ci ruch�w graczy
 */
public final class MoveValidationHandler {
	
	/**
	 * Prywatny konstruktor maj�cy zapewni� statyczno�� ca�ej klasy
	 */
	private MoveValidationHandler() {
	}
	
	/**
	 * Podstawowa metoda sprawdzaj�ca poprawno�� ruchu
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
	 * Sprawdza, czy wsp�rz�dne ruchu nie wykraczaj� poza plansz�
	 * @param playerMove
	 * @return
	 */
	private static boolean IsInRangeOfBoard(Stone playerMove){
		return playerMove.coordinates.getX() > 0 && playerMove.coordinates.getX() < 20 &&
			   playerMove.coordinates.getY() > 0 && playerMove.coordinates.getY() < 20;
				
	}
}
