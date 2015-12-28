package modelviewcontroller;
import java.util.*;
import javax.swing.*;

import commands.CommandProcessor;

import controllers.*;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionListener;

public class BrickGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// the model of the brick
	protected Brick theModel;
	// the controller of the file menu
	protected CADGUIController fileMenuController;
	// the controller of the view menu
	protected CADGUIController viewMenuController;
	// the controller of the edit menu
	protected CADGUIController editMenuController;
	// the controller of the dimension view menu item
	protected CADGUIController dimensionController;
	protected CADGUIController helpMenuController;
	// the parent desktop
	private JDesktopPane desktop;
	
	private CommandProcessor processor;
	
	public CommandProcessor getProcessor() {return processor;}
	
	/**
	 * Constrcuts a default BrickGUI
	 */
	protected BrickGUI() {
		theModel = new Brick();
		desktop = new JDesktopPane();
		processor = new CommandProcessor();
		
		
		setContentPane(desktop);

		fileMenuController = new FileMenuController(this, processor);
		viewMenuController = new ViewMenuController(this, processor);
		editMenuController = new EditMenuController(this, processor);
		helpMenuController = new HelpMenuController(this, processor);
	}
	
	public void setDesktop(JDesktopPane desk)
	{
		//desktop = desk;
		desktop.removeAll();
		//desktop.setBackground(Color.white);
		setContentPane(desktop);
	}
	/**
	 * Making the menus and the menu items
	 *   appear on the frame
	 * @return
	 */
	private JMenuBar makeMenus() {
		JMenuBar menu = new JMenuBar();
		
		/* File Pull-down Menu */
		JMenu fileMenu = new JMenu("File");
		// new button
		JMenuItem newButton = new JMenuItem("New");
		newButton.addActionListener(fileMenuController);
		fileMenu.add(newButton);
		// open menu
		JMenuItem openButton = new JMenuItem("Open");
		openButton.addActionListener(fileMenuController);
		fileMenu.add(openButton);
		// save menu
		JMenuItem saveButton = new JMenuItem("Save");
		saveButton.addActionListener(fileMenuController);
		fileMenu.add(saveButton);
		// save as
		JMenuItem saveAsButton = new JMenuItem("SaveAs");
		saveAsButton.addActionListener(fileMenuController);		
		fileMenu.add(saveAsButton);
		// exit 
		JMenuItem exitButton = new JMenuItem("Exit");
		exitButton.addActionListener(fileMenuController);
		fileMenu.add(exitButton);

		menu.add(fileMenu); // add file pull down menu
		
		/* Edit Pull-down Menu */
		JMenu editMenu = new JMenu("Edit");
		// edit height
		JMenuItem editHeightButton = new JMenuItem("Edit Height");
		editHeightButton.addActionListener(editMenuController);
		editMenu.add(editHeightButton);
		// edit Width
		JMenuItem editWidthButton = new JMenuItem("Edit Width");
		editWidthButton.addActionListener(editMenuController);
		editMenu.add(editWidthButton);
		//edit length
		JMenuItem editLengthButton = new JMenuItem("Edit Length");
		editLengthButton.addActionListener(editMenuController);
		editMenu.add(editLengthButton);
		// undo
		JMenuItem undoButton = new JMenuItem("Undo");
		undoButton.addActionListener(editMenuController);
		editMenu.add(undoButton);
		// redo
		JMenuItem redoButton = new JMenuItem("Redo");
		redoButton.addActionListener(editMenuController);
		editMenu.add(redoButton);
		
		menu.add(editMenu); // add edit menu pull down menu
		
		/* View Pull-down Menu*/
		JMenu viewMenu = new JMenu("View");
		// Front button
		JMenuItem frontView = new JMenuItem("Front View");
		frontView.addActionListener(viewMenuController);
		viewMenu.add(frontView);
		// side button
		JMenuItem sideView = new JMenuItem("Side View");
		sideView.addActionListener(viewMenuController);
		viewMenu.add(sideView);
		// top button
		JMenuItem topView = new JMenuItem("Top View");
		topView.addActionListener(viewMenuController);
		viewMenu.add(topView);
	    // dimension view
		JMenuItem dimensionView = new JMenuItem("Dimension View");
		dimensionView.addActionListener(viewMenuController);
		viewMenu.add(dimensionView);
		
		menu.add(viewMenu); // add view menu pull down menu	
		
		
		/* Help menu */
		JMenu helpMenu = new JMenu("Help");
		// About button
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(helpMenuController);
		helpMenu.add(about);
		
		menu.add(helpMenu); //add the help menu
		
		return menu; //return finalized result
	}
    /*protected void createFrame() {
        DimensionView frame = new DimensionView();
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);

       try {
           frame.setSelected(true);
       } catch (java.beans.PropertyVetoException e) {}

    }*/
	
	/**
	 * Display the frame
	 * @param frame the frame
	 */
	public void display(BrickGUI frame)
	{
	      //BrickGUI frame = new BrickGUI();
		  frame.setJMenuBar(makeMenus());
	      frame.setSize(300, 400);
	     // makeMenus();
	      //setJMenuBar(menuBar);
	      frame.setTitle("App Frame");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	}
	
	   public static void main(String[] args) {
		   
		   BrickGUI frame = new BrickGUI();
		   frame.setSize(1000, 800);
		   frame.setJMenuBar(frame.makeMenus());
		      //frame.createFrame();
		   frame.setTitle("Brick CAD");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setVisible(true);

		}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	/**
	 * gets the the model of the brick
	 * @return
	 */
	public Brick getBrick() {
		return theModel;
		}


	/**
	 * gets the parend desktop
	 * @return
	 */
	public JDesktopPane getDesktop() {
		return desktop;
	}


	/*
	 * set the model to the saved model
	 * @param savedModel the saved model
	 */
	public void setTheModel(Brick savedModel) {
		theModel = savedModel;
		
	}

}
