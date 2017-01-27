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
		int setX =0;
		int coordinateX = mnoznik;
		while(coordinateX < x){
			coordinateX = coordinateX + a*mnoznik;
			a++;
		}
		if((a*mnoznik + mnoznik > x)&&(x < (a+1)*mnoznik + mnoznik))
		{
			setX = (x - coordinateX < mnoznik/2) ? (int) a : (int) a+1;
		}
		return (double) setX;
	}
	private double HandlerY(int mnoznik, int width ,int y){
		int a =0;
		int setY =0;
		int coordinateY = mnoznik;
		while(coordinateY < y){
			coordinateY = coordinateY + a*mnoznik;
			a++;
		}
		if((a*mnoznik + mnoznik > y)&&(y < (a+1)*mnoznik + mnoznik))
		{
			setY = (y - coordinateY < mnoznik/2) ? (int) a : (int) a+1;
		}
		return (double) setY;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		point.setLocation(new Random().nextInt(19),new Random().nextInt(19));
		board.playerMove = new Stone(point);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
