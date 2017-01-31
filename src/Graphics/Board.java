package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Client.MoveActionThread;
import Graphics.ActionListeners.BoardActionListener;
import Models.PlayerSide;
import Models.Stone;

public class Board extends JPanel{
	private static final long serialVersionUID = 1L;
	private int height;
	public  int width;
	public ArrayList<Stone> points;
	public volatile Stone playerMove;
	public volatile boolean moveValue;
	public JTextArea text;
	public int mnoznik = width/21;
	private BoardActionListener listener;
	public Board(int width, int height, ObjectOutputStream output, ObjectInputStream input, JTextArea text){
		super();
		this.height = height;
		this.width = width;
		this.text = text;
		setSize(width , height );
		setBorder( new TitledBorder ( new EtchedBorder (), "" ) );
		setForeground(Color.BLACK);
		listener = new BoardActionListener(this, mnoznik);
		addMouseListener(listener);
		playerMove = null;
		new Thread(new MoveActionThread(this, input, output)).start();
	}

		public void setListOfPoints(ArrayList<Stone> points){
			this.points = points;
		}
		
	    private void doDrawing(Graphics g) {

	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(Color.BLACK);
	        //rysowaqnie planszy
	        int mnoznik = width/21;
	        int sizeOfPoint = mnoznik/2;
	          	for(int i=0 ;i<19 ;i++){
	        		//linie pionowe
	        		g2d.drawLine(mnoznik + mnoznik * i, mnoznik, mnoznik + mnoznik * i, width - mnoznik);
	        		//linie poziome
	        		g2d.drawLine(mnoznik ,mnoznik + i * mnoznik, width - mnoznik ,mnoznik + mnoznik *i);
	        	}
	        	g2d.drawLine(mnoznik, width - mnoznik, width - mnoznik, width - mnoznik);
	        	g2d.drawLine(width - mnoznik, mnoznik, width - mnoznik, width - mnoznik);
	        if(points != null){
	        	for(Stone f : points){
	        		if(f == null)
	        		{}
	        		else{
	        			if(f.color.equals(PlayerSide.Black)){
	        				g2d.setColor(Color.BLACK);
	        				g2d.fillOval((int)f.coordinates.getX() * mnoznik - sizeOfPoint/2, (int) f.coordinates.getY() * mnoznik - sizeOfPoint/2, sizeOfPoint, sizeOfPoint);
	        			}else{
	        				g2d.setColor(Color.WHITE);
	        				g2d.fillOval((int)f.coordinates.getX() * mnoznik - sizeOfPoint/2, (int) f.coordinates.getY() * mnoznik - sizeOfPoint/2, sizeOfPoint, sizeOfPoint);
	        			}
	        		}
	        	}
	        }
	    }
	    	

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        doDrawing(g);
	    }
}
