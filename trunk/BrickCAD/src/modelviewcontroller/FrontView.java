package modelviewcontroller;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * A class that creates the front view of the brick
 *
 */
public class FrontView extends JInternalFrame implements Observer {

private static final long serialVersionUID = 1L;

	// the model of the brick
	private Brick theModel;
	
	/**
	 * Constructs a FrontView by creating an internal frame
	 *   of the front view
	 * @param model the model of the brick
	 */
	public FrontView( Brick model)
	{
		super("Front View",true,true,true,true);
		theModel = model;
		setSize(400,400);
		theModel.addObserver(this);
		repaint();
	//paintComponent(frame.getGraphics());
}
	
	/**
	 * updates any changes that occur
	 */
	public void update(Observable o, Object arg) 
	{	
		repaint();
	}
	
	@Override
	/**
	 * Paints the rectangle that represents
	 *   the front view of the rectangle
	 */
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		//System.out.println(g);
		//g.setColor(Color.RED);
		//g.drawString("abcdefgh", 30, 50);
		//g.fillRect(10,10,100,200);
		//System.out.println(theModel.getHeight() + " " + theModel.getWidth() + " " + theModel.getLength());
		//int cwidth = getBounds().width;
		//int cheight = getBounds().height;
		Rectangle2D.Double rectangle = new Rectangle2D.Double(30,70,theModel.getWidth(),theModel.getHeight());
		g2.setColor(Color.RED);
		g2.fill(rectangle);
	}
}