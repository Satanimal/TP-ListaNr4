package Models;

import java.awt.geom.Point2D;

public class Stone{
	public Point2D coordinates;
	public PlayerSide color;
	
	public Stone(Point2D coordinates, PlayerSide playerSide){
		this.coordinates = coordinates;
		this.color = playerSide;
	}
}
