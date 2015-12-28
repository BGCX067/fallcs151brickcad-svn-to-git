package controllers;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import commands.CommandProcessor;

import modelviewcontroller.Brick;
import modelviewcontroller.BrickGUI;
import modelviewcontroller.CADGUIController;

public class FileMenuController extends CADGUIController {


	private File currentDir;
	
	/**
	 * Constructor for the FileController
	 * @param processor 
	 * @param mazeGUI for reference back to mazeGUI
	 */
	public FileMenuController(BrickGUI GUI, CommandProcessor processor) {
		super(GUI, processor);
		File f = getModel().getFile();
		if(f != null) {
			currentDir = f.getParentFile();
		}
	}
	
	/**
	 * Asks user if model should be saved
	 * @return true if yes
	 */
	private boolean saveChanges() {
		if (!getModel().isChanged()) return false;
		int choice = JOptionPane.showConfirmDialog(GUI, "save changes?");
		return choice == 0;
		//return true;
	}
	/**
	 * Prompts user for file to be saved or open
	 * @return the selected file
	 */
	private File getFile() {
		 JFileChooser chooser = new JFileChooser();
		 if (currentDir != null) {
			 chooser.setCurrentDirectory(currentDir);
		 }
		 chooser.showOpenDialog(GUI);
		 File result = chooser.getSelectedFile();
		 if(result == null) {
			 //System.out.println("Needs input");
		 } else {
			 currentDir = result.getParentFile();
		 }
		 return result;
	}
	/**
	 * Replaces existing model with model read from selected file.
	 */
	private void open() {
		File f = getFile();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			Brick savedModel = (Brick)ois.readObject();

			GUI.setDesktop(new JDesktopPane());
			GUI.setTheModel(savedModel);
		} catch(Exception e) {
			//System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Saves model to selected file.
	 * @param saveAs prompt user for new file if true
	 */
	private void save(boolean saveAs) {
		Brick theModel = getModel();
		if (!saveAs && !theModel.isChanged()) return; // nothing to do
		File f = theModel.getFile();
		if (f == null || saveAs) {
			f = getFile();
			theModel.setFile(f);
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(theModel);
			theModel.setChanged(false);
		} catch(Exception e) {
			//System.out.println(e.getMessage());
		}
	}

	/**
	 * The action that was performed
	 * @param e action event that was performed
	 */
	public void actionPerformed(ActionEvent e) {
		String cmmd = e.getActionCommand();
		if (cmmd.equals("New")) {
			if(saveChanges()) save(false);

			GUI.setDesktop(new JDesktopPane());
			getModel().setHeight(20.0);
			getModel().setWidth(30.0);
			getModel().setLength(120.0);
			//GUI.setTheModel();//.setModel(new Brick());
			getModel().seChanged();
			getModel().setChanged(false);
		} else if (cmmd.equals("Exit")) {
			if (saveChanges()) save(false);
			System.exit(0);
		} else if (cmmd.equals("Save")) {
			save(false);

		} else if (cmmd.equals("SaveAs")) {
			save(true);

		} else if (cmmd.equals("Open")) {
			if (saveChanges()) save(false);
			open();

		} else {
			System.out.println("unrecognized command: " + cmmd);
		}
	}

}
