package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Models.BaseSocketModel;
import Models.ListOfGamesModel;
import Models.PlayerSide;
import Models.PlayerTurnModel;
import Models.Stone;

public class Board extends JPanel implements Runnable{
	private int height;
	public  int width;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ArrayList<Stone> points;
	private PlayerTurnModel stoneList;
	private BaseSocketModel message;
	private JTextArea text;
	public int mnoznik = width/21;
	public boolean moveValue;
	private BoardActionListener listener;
	public Board(int width, int height, ObjectOutputStream output, ObjectInputStream input, JTextArea text){
		super();
		this.input = input;
		this.output = output;
		this.height = height;
		this.width = width;
		this.text = text;
		setSize(width , height );
		setBorder( new TitledBorder ( new EtchedBorder (), "" ) );
		setForeground(Color.BLACK);
		listener = new BoardActionListener(this, input, output, mnoznik);
		addMouseListener(listener);
		new Thread(listener).start();
		
		}
    	@Override
    	public void run() {
    		while(true){
    			try {
    			message = (BaseSocketModel) input.readObject();
    			System.out.println(message.message);
    			text.setText(message.message);
    			switch(message.message){
    				case  "yourTurn" : stoneList = (PlayerTurnModel) message;
    						setListOfPoints(stoneList.board);
    						moveValue = true;
    						repaint();
    						break;
    				case "opponentTurn" : 
    						stoneList = (PlayerTurnModel) message;
    						setListOfPoints(stoneList.board);
    						moveValue = false;
    						repaint();
    						break;
    				case "invalidMove" : JOptionPane.showMessageDialog(null, "B³êdny ruch");
    						moveValue = true;
    						break;
    			}
    			} catch (IOException e) {
    				System.exit(1);
    				e.printStackTrace();
    			} catch (ClassNotFoundException e) {}
    	}
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
	      if(points == null){}
	      else{
	        	for(Stone f : points){
	        		if(f == null)
	        		{}
	        		else{
	        			if(f.color.name().equals("Black")){
	        				g2d.setColor(Color.BLACK);
	        				g2d.fillOval((int)f.coordinates.getX() * mnoznik, (int) f.coordinates.getY() * mnoznik, sizeOfPoint, sizeOfPoint);
	        			}else{
	        				g2d.setColor(Color.WHITE);
	        				g2d.fillOval((int)f.coordinates.getX() * mnoznik, (int) f.coordinates.getY() * mnoznik, sizeOfPoint, sizeOfPoint);
	        			}
	        		}
	        	}
	    }}
	    	

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        doDrawing(g);
	    }
}
