package modelviewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commands.CommandProcessor;

public class CADGUIController implements ActionListener {
	protected BrickGUI GUI;
	protected CommandProcessor processor;
	
	public CADGUIController(BrickGUI GUI, CommandProcessor cmdProcess) {
		this.GUI = GUI;
		processor = cmdProcess;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public Brick getModel() {return GUI.getBrick();}

}
