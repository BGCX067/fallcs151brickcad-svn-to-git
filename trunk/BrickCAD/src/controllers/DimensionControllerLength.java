package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import commands.ChangeHeight;
import commands.ChangeLength;
import commands.CommandProcessor;

import modelviewcontroller.BrickGUI;

public class DimensionControllerLength extends DimensionController {

	public DimensionControllerLength(BrickGUI GUI, CommandProcessor processor) {
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
			processor.execute(new ChangeLength(GUI.getBrick(), theData));
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "You must enter a positive number","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
