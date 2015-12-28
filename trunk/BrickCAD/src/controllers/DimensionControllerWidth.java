package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelviewcontroller.BrickGUI;

import commands.ChangeHeight;
import commands.ChangeWidth;
import commands.CommandProcessor;

public class DimensionControllerWidth extends DimensionController {

	public DimensionControllerWidth(BrickGUI GUI, CommandProcessor processor) {
		super(GUI, processor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		JTextField text = (JTextField) e.getSource();
		double theData = Double.parseDouble(text.getText());
		if (theData<=0)
			JOptionPane.showMessageDialog(null, "You must enter a positive number","Error",JOptionPane.ERROR_MESSAGE);
		else
			processor.execute(new ChangeWidth(GUI.getBrick(), theData));
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "You must enter a positive number","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
