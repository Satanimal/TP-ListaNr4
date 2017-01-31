package Models;

import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Klasa reprezentuj¹ca kamieñ.
 * Zawiera informacjê na temat koloru(strony gracza), oraz wspó³rzêdne
 */
public class Stone implements Serializable{

	private static final long serialVersionUID = 1L;
	public Point2D coordinates;
	public PlayerSide color;
	
	public Stone(Point2D coordinates){
		this.coordinates = coordinates;
	}
}
