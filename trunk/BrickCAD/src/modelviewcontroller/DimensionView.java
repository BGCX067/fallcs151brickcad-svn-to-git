package modelviewcontroller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import controllers.*;

import javax.swing.JInternalFrame;

/**
 * a class that creates the dimension view internal frame
 */
public class DimensionView extends JInternalFrame implements Observer {

	private static final long serialVersionUID = 1L;
	// the model of the brick
	private Brick theModel;
	// the GUI of the brick
	private BrickGUI theGUI;
	// the label of the length
    private JLabel lengthLabel;
    // the label of the length
    private JLabel heightLabel;
    // the label of the width
    private JLabel widthLabel;
    // the label of a sentence that tells the user what to do
    private JLabel theSentence;
    // the text field of the length
    private JTextField lengthTextField;
    // the text field of the height
    private JTextField heightTextField;
    // the text field of the width
    private JTextField widthTextField;
    // the dimension controller of the height
    private DimensionControllerHeight dimensionControllerHeight;
    // the dimension controller of the width
    private DimensionControllerWidth dimensionControllerWidth;
    // the dimension controller of the length
    private DimensionControllerLength dimensionControllerLength;

    
    /**
     * Constructs a DimensionView that creates an 
     * internal frame with labels and text fields for 
     * the length, width, height, 
     * and adds those text fields to the actionlistener
     * of the dimension controller of each
     * @param gui the GUI of the brick
     */
	public DimensionView( BrickGUI gui)
	{
		super("Dimension View",true,true,true,true);
		theGUI = gui;
		theModel = theGUI.getBrick();
		dimensionControllerHeight = new DimensionControllerHeight(theGUI, gui.getProcessor());
		dimensionControllerWidth = new DimensionControllerWidth(theGUI, gui.getProcessor());
		dimensionControllerLength = new DimensionControllerLength(theGUI, gui.getProcessor());
		setLayout(new FlowLayout());
		Container c1 = getContentPane();
		lengthLabel = new JLabel("Length:");
		c1.add(lengthLabel);
		lengthTextField = new JTextField(""+theModel.getLength(),15);
		lengthTextField.addActionListener(dimensionControllerLength);
		c1.add(lengthTextField);
		Container c2 = getContentPane();
		heightLabel = new JLabel("Height:");
		c2.add(heightLabel);
		heightTextField = new JTextField(""+theModel.getHeight(),15);
		heightTextField.addActionListener(dimensionControllerHeight);
		c2.add(heightTextField);
		Container c3 = getContentPane();
		widthLabel = new JLabel("Width:");
		c3.add(widthLabel);
		widthTextField = new JTextField(""+theModel.getWidth(),15);
		widthTextField.addActionListener(dimensionControllerWidth);
		c3.add(widthTextField);
		Container c4 = getContentPane();
		theSentence = new JLabel("Type text in a field and press Enter.");
		c4.add(theSentence);
		
		theModel.addObserver(this);
		widthTextField.setText("" + theModel.getWidth());

		lengthTextField.setText("" + theModel.getLength());

		heightTextField.setText("" + theModel.getHeight());
		repaint();	
}
	/**
	 * updates any changes that occur
	 * @param arg0
	 * @param arg1
	 */
	public void update(Observable arg0, Object arg1) {
		widthTextField.setText("" + theModel.getWidth());

		lengthTextField.setText("" + theModel.getLength());

		heightTextField.setText("" + theModel.getHeight());
		repaint();
		
	}
}
