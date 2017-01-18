package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Board extends JPanel{
	private int height;
	private int width;
	public Board(int width, int height){
		super();
		this.height = height;
		this.width = width;
		setSize(width , height );
		setBounds(1, 1, width, height );
		//this.setBorder( new TitledBorder ( new EtchedBorder (), "" ) );
		setForeground(Color.BLACK);
	}
	
	   private void doDrawing(Graphics g) {

	        Graphics2D g2d = (Graphics2D) g;
	        //rysowaqnie planszy
	        int mnoznik = width/19;
	        int start =1;
	        //g2d.drawLine();
	        	for(int i=0 ;i<19 ;i++){
	        		//linie pionowe
	        		g2d.drawLine(mnoznik * start, 1, mnoznik * start, mnoznik * 19);
	        		//linie poziome
	        		g2d.drawLine(1, start * mnoznik, mnoznik * 19, start * mnoznik);
	        		start++;
	        	}
	        	g2d.drawLine(1, 1, mnoznik * 19, 1);
	        	g2d.drawLine(1, 1, 1, mnoznik *19);
	        	g2d.setColor(Color.YELLOW);
	        	g2d.fillOval(mnoznik*5 - mnoznik/4, mnoznik*7 - mnoznik/4, mnoznik/2, mnoznik/2);
	        	
	        	
	    }

	    @Override
	    public void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        doDrawing(g);
	    }
}
