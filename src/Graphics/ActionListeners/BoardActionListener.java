package Graphics.ActionListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import Graphics.Board;
import Models.Stone;

/**
 * ActionListener dla planszy, zbieraj�cy ruchy gracza
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
	 * Przelicza wsp�rz�dne klikni�cia na indeks planszy
	 * @param width szeroko�� planszy
	 * @param x zebrana wsp�rz�dna x z klikni�cia gracza
	 * @return najbli�szy do klikni�cia indeks
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
	 * Przelicza wsp�rz�dne klikni�cia na indeks planszy
	 * @param width szeroko�� planszy
	 * @param y zebrana wsp�rz�dna y z klikni�cia gracza
	 * @return najbli�szy do klikni�cia indeks
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
