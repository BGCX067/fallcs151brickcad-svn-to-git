package modelviewcontroller;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.*;

/**
 * 
 * A class that creates the front view of the brick
 *
 */
public class TopView extends JInternalFrame  implements Observer {

private static final long serialVersionUID = 1L;

	//the model of the brick
	private Brick theModel;
	
	/**
	 * Constructs a TopView by creating an internal frame
	 *   of the top view
	 * @param model the model of the brick
	 */
	public TopView(Brick model)
	{
		super("Top View",true,true,true,true);
		theModel = model;
		theModel.addObserver(this);
		setSize(400,400);
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
	 *   the top view of the rectangle
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
		Rectangle2D.Double rectangle = new Rectangle2D.Double(30,70,theModel.getWidth(),theModel.getLength());
		g2.setColor(Color.RED);
		g2.fill(rectangle);
	}
}