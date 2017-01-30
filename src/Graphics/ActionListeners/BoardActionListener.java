package Graphics.ActionListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.Random;

import Graphics.Board;
import Models.PlayerTurnModel;
import Models.Stone;

public class BoardActionListener implements MouseListener{
	private Board board;
	private PlayerTurnModel model;
	private int mnoznik;
	private Point2D point;
	public BoardActionListener(Board board, int mnoznik){
		this.board = board;
		this.mnoznik = mnoznik;
		point = new Point2D.Double();
	}

    private double HandlerX(int mnoznik, int width ,int x){
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
	private double HandlerY(int mnoznik, int width ,int y){
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
		point.setLocation(HandlerX(mnoznik, board.width,arg0.getX()),HandlerY(mnoznik, board.width,arg0.getY()));
		board.playerMove = new Stone(point);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
