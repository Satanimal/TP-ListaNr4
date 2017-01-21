package Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import Handlers.GraphicsHandler;
import Models.BaseSocketModel;
import Models.PlayerMoveModel;
import Models.PlayerTurnModel;
import Models.Stone;

public class BoardActionListener implements MouseListener, Runnable{
	private Board board;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private PlayerTurnModel model;
	private int mnoznik;
	private Point2D point;
	public BoardActionListener(Board board, ObjectInputStream input, ObjectOutputStream output, int mnoznik){
		this.board = board;
		this.input = input;
		this.output = output;
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
			try {
				point.setLocation(HandlerX(mnoznik, board.width , arg0.getX()), HandlerY(mnoznik,board.width, arg0.getY()));
				board.moveValue = false;
				output.writeObject(new  PlayerMoveModel("", new Stone(point)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void run() {
	}
}
