package Handlers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import Logic.Game;
import Models.Stone;

public final class GraphicsHandler {
	private static JRadioButton selected;
	private GraphicsHandler(){	
	}
	
	public static Point2D CalculateOnScreenCoordinates(Point2D point, double windowHeight, double windowWidth){
		return null;
	}
	
	public static ArrayList<Stone> GetBoardOnScreen(ArrayList<Stone> board, double windowHeight, double windowWidth){
		return null;
	}
	
	public static int getIdBySelect(Game game){
		return 1;
	}
	
	public static Game getSelectedGame(ButtonGroup group){
		selected = (JRadioButton) group.getSelection();
		
		return null;
		
	}
}
