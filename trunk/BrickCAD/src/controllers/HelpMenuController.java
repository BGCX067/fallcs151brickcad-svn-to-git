package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import commands.CommandProcessor;

import modelviewcontroller.BrickGUI;
import modelviewcontroller.CADGUIController;

public class HelpMenuController extends CADGUIController {
	public HelpMenuController(BrickGUI GUI, CommandProcessor cmdProcess) {
		super(GUI, cmdProcess);
	}
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "\tBrick CAD\n" +
				"Porpose: \n" +
				"         A CAD program to display a side, front, and top view\n" +
				"         of a brick, using the design patterns we have learned\n" +
				"         in out object oriented design class\n" +
				"Authors: \n" +
				"         -Jeffrey Steven Rhodes\n" +
				"         -Andrew Stephen Egelhofer\n" +
				"         -Bshara Choufany\n" +
				"Version: 1.00.00 (December, 01, 2009)\n" +
				"Copyright (c) 2009 by Andrew Egelhofer\n" +
				"For instructional purposes only.  No warranties\n" +
				"\nFor more information, or to access the source code visit:\n" +
				"http://code.google.com/p/fallcs151brickcad/",
				"About",JOptionPane.INFORMATION_MESSAGE);
	}
}
