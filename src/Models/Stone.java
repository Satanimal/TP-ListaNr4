package Models;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class Stone implements Serializable{

	private static final long serialVersionUID = 1L;
	public Point2D coordinates;
	public PlayerSide color;
	
	public Stone(Point2D coordinates, PlayerSide playerSide){
		this.coordinates = coordinates;
		this.color = playerSide;
	}
}
