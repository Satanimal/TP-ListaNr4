package Handlers;

import java.util.ArrayList;

import Models.PlayerSide;
import Models.Stone;

public final class MoveValidationHandler {
	private static final PlayerSide Black = null;
	private static final PlayerSide White = null;
	private static PlayerSide[][] tab;
	public static float blackCaptured;
	public static float whiteCaptured;
	private static int tempX;
	private static int tempY;
	public static int[][] temp;
	//Private constructor to simulate static class - no instance can be created
	private MoveValidationHandler() {
		tab = new PlayerSide[19][19];
		temp = new int[19][19];
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				tab[i][j]=null;
				temp[i][j]=0;
			}
		}
		
	}
	
	private static void SetTempXY(Stone playerMove){
		tempX = (int) playerMove.coordinates.getX();
		tempY = (int) playerMove.coordinates.getY();
	}
	
	private static void SetArray(ArrayList<Stone> board){
		for(Stone stone : board){
			tab[(int)stone.coordinates.getX()][(int)stone.coordinates.getY()] = stone.color;
			
		}
	}
	
	private static void SetUp(ArrayList<Stone> board, Stone playerMove){
		SetTempXY(playerMove);
		SetArray(board);
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
	
	private static boolean IsInBoard(int x,int y){
		return 0 <= x && x < 20 && 0 <= y && y < 20;
		
	}
	
	private static boolean IsInRangeOfBoard(Stone playerMove){
		return playerMove.coordinates.getX() > 0 && playerMove.coordinates.getX() < 20 &&
			   playerMove.coordinates.getY() > 0 && playerMove.coordinates.getY() < 20;
				
	}
	public static void AttemptToRemove(ArrayList<Stone> board, Stone playerMove){
			PlayerSide color = playerMove.color;
			PlayerSide opponentColor = opponentColor(playerMove);
			int x = (int) playerMove.coordinates.getX();
			int y = (int) playerMove.coordinates.getY();
			
			if(IsInBoard(x - 1, y))
				if(tab[x - 1][y] == opponentColor && !IsNotTaken(x - 1, y, opponentColor, new PlayerSide[19][19])) {
					Remove(x - 1, y, opponentColor);
				}
			if(IsInBoard(x, y - 1))
				if(tab[x][y - 1] == opponentColor && !IsNotTaken(x, y - 1, opponentColor, new PlayerSide[19][19])) {
					Remove(x, y - 1, opponentColor);
				}
			if(IsInBoard(x + 1, y))
				if(tab[x + 1][y] == opponentColor && !IsNotTaken(x + 1, y, opponentColor, new PlayerSide[19][19])) {
					Remove(x + 1, y, opponentColor);
				}
			if(IsInBoard(x, y + 1))
				if(tab[x][y + 1] == opponentColor && !IsNotTaken(x, y + 1, opponentColor, new PlayerSide[19][19])) {
					Remove(x, y + 1, opponentColor);
				}
		}
	

		private static void Remove(int x, int y, PlayerSide color) {
				tab[x][y] = null;
					if(color == Black)
						whiteCaptured++;
					if(color == White)
						blackCaptured++;
	
					if(IsInBoard(x - 1, y) && tab[x - 1][y] == color)
						Remove(x - 1, y, color);	
					if(IsInBoard(x, y - 1) && tab[x][y - 1] == color)
						Remove(x, y - 1, color);
					if(IsInBoard(x + 1, y) && tab[x + 1][y] == color)
						Remove(x + 1, y, color);
					if(IsInBoard(x, y + 1) && tab[x][y + 1] == color)
						Remove(x, y + 1, color);
		}


		private static boolean IsNotTaken(int x, int y, PlayerSide color, PlayerSide[][] tab) {
			if(tab[x][y] == null)
				return true;
			if(tab[x][y] != null)
				return false;
			if(tab[x][y].equals(PlayerSide.Black)&&tab[x][y].equals(PlayerSide.White))
				return false;
	
			tab[x][y] = color.Black;
			boolean isNotTaken = false;
	
			if(IsInBoard(x - 1, y))
				isNotTaken = isNotTaken || IsNotTaken(x - 1, y, color, tab);
			if(IsInBoard(x, y - 1))
				isNotTaken = isNotTaken || IsNotTaken(x, y - 1, color, tab);
			if(IsInBoard(x + 1, y))
				isNotTaken = isNotTaken || IsNotTaken(x + 1, y, color, tab);
			if(IsInBoard(x, y + 1))
				isNotTaken = isNotTaken || IsNotTaken(x, y + 1, color, tab);
	
			return isNotTaken;
		}

	
	private static PlayerSide opponentColor(Stone side){
		if(side.color == Black )
			return White;
		else
			return Black;
	}
}
