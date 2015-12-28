package controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import commands.*;


import modelviewcontroller.Brick;
import modelviewcontroller.BrickGUI;
import modelviewcontroller.CADGUIController;

public class EditMenuController extends CADGUIController {

	private BrickGUI gui;
	
	public EditMenuController(BrickGUI gui, CommandProcessor processor) {
		super(gui, processor);
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		double theData = 0.0;
		String data = null;
		if (cmd.equals("Edit Height")){
			try{
				data = JOptionPane.showInputDialog("Please Input new Height");
				if(data != null) {
					theData = Double.parseDouble(data);
					if (theData<=0)
						JOptionPane.showMessageDialog(null, "You must enter a positive number",
								"Error",JOptionPane.ERROR_MESSAGE);
					else
						processor.execute(new ChangeHeight(gui.getBrick(), theData));
				}
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "You must enter a positive number",
						"Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if (cmd.equals("Edit Width")){
			try{
				data = JOptionPane.showInputDialog("Please Input new Width");
				if(data != null) {
					theData = Double.parseDouble(data);
					if (theData<=0)
						JOptionPane.showMessageDialog(null, "You must enter a positive number",
								"Error",JOptionPane.ERROR_MESSAGE);
					else
						processor.execute(new ChangeWidth(gui.getBrick(), theData));
				}
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "You must enter a positive number",
						"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (cmd.equals("Edit Length")){
			try{
				data = JOptionPane.showInputDialog("Please Input new Length");
				if(data != null) {
					theData = Double.parseDouble(data);
					if (theData<=0)
						JOptionPane.showMessageDialog(null, "You must enter a positive number",
								"Error",JOptionPane.ERROR_MESSAGE);
					else
						processor.execute(new ChangeLength(gui.getBrick(), theData));
				}
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "You must enter a positive number",
						"Error",JOptionPane.ERROR_MESSAGE);
			}
		} else if(cmd.equals("Undo")) {
			processor.undo();
		} else if(cmd.equals("Redo")) {
			processor.redo();
		}
		
	}

}
