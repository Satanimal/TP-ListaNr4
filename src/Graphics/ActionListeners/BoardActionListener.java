package Graphics.ActionListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import Graphics.Board;
import Models.Stone;

/**
 * ActionListener dla planszy, zbieraj¹cy ruchy gracza
 */
public class BoardActionListener implements MouseListener{
	private Board board;
	private int mnoznik;
	private Point2D point;
	public BoardActionListener(Board board, int mnoznik){
		this.board = board;
		this.mnoznik = mnoznik;
		point = new Point2D.Double();
	}

	/**
	 * Przelicza wspó³rzêdne klikniêcia na indeks planszy
	 * @param width szerokoœæ planszy
	 * @param x zebrana wspó³rzêdna x z klikniêcia gracza
	 * @return najbli¿szy do klikniêcia indeks
	 */
    private double HandlerX(int width ,int x){
		int a =0;
		int coordinateX;
		int start = (int) width/20;
		coordinateX = start;
		do{
			coordinateX = coordinateX + start;
			a++;
		}while(coordinateX <=x);
		return (coordinateX - x < start/2) ? (double) a-1 : (double) a;
	}
    
	/**
	 * Przelicza wspó³rzêdne klikniêcia na indeks planszy
	 * @param width szerokoœæ planszy
	 * @param y zebrana wspó³rzêdna y z klikniêcia gracza
	 * @return najbli¿szy do klikniêcia indeks
	 */
	private double HandlerY(int width ,int y){
		int a =0;
		int coordinateY;
		int start = (int) width/20;
		coordinateY = start;
		do{
			coordinateY = coordinateY + start;
			a++;
		}while(coordinateY <=y);
		return (coordinateY - y < start/2) ? (double) a-1 : (double) a;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		point.setLocation(HandlerX(board.width,arg0.getX()),HandlerY(board.width,arg0.getY()));
		board.playerMove = new Stone(point);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
