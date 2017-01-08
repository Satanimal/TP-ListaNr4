package Handlers;

import java.util.ArrayList;

import Models.Stone;

public final class MoveValidationHandler {
	
	//Private constructor to simulate static class - no instance can be created
	private MoveValidationHandler() {
	}
	
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
	
	private static boolean IsInRangeOfBoard(Stone playerMove){
		return playerMove.coordinates.getX() > 0 && playerMove.coordinates.getX() < 20 &&
			   playerMove.coordinates.getY() > 0 && playerMove.coordinates.getY() < 20;
				
	}
}
