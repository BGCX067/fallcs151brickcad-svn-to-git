package controllers;

import java.awt.event.ActionEvent;

import commands.CommandProcessor;

import modelviewcontroller.BrickGUI;
import modelviewcontroller.CADGUIController;

public abstract class DimensionController extends CADGUIController {

	public DimensionController(BrickGUI GUI, CommandProcessor processor) {
		super(GUI, processor);
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);

}
