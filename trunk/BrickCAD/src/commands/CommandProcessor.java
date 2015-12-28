package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JOptionPane;


import momento.Originator;

/**
 * 
 * A class that handles the undo and redo
 *   options in the edit menu
 *
 */
public class CommandProcessor {
	
	// the undo stack to undo
	private Stack<Command> undoStack;
	// the redo stack to redo
	private Stack<Command> redoStack;
	
	/**
	 * Constructs a default CommandProcessor
	 */
	public CommandProcessor() {
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
	}
	
	/*
	 * Getting the undo option to work
	 *  by popping the last element off the undo stack
	 *   and pushing it to the redo stack
	 */
	public void undo() {
		//System.out.println(this);
		if (!undoStack.isEmpty()) {
			Command c = undoStack.pop();
			c.undo();
			redoStack.push(c);
		} else {
			JOptionPane.showMessageDialog(null, "Nothing to Undo",
					"Undo Stack Empty",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Getting the redo option to work
	 *  by popping the last element off the redo stack
	 *    and pushing it to the undo stack 
	 */
	public void redo() {
		if(!redoStack.isEmpty()) {
			Command c = redoStack.pop();
			c.undo();
			undoStack.push(c);
		} else {
			JOptionPane.showMessageDialog(null, "Nothing to Redo",
					"Redo Stack Empty",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void execute(Command cmd) {
		try {
			cmd.execute();
		} catch (NegativeVector e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					"Error",JOptionPane.ERROR_MESSAGE);
		}
	
		undoStack.push(cmd);
		//to follow the undo/redo behavior of regular programs once you
		//execute a command, redos dont exits, so purge the stack
		redoStack.removeAllElements();
		//System.out.println(this);
	}

	@Override
	public String toString() {
		return "CommandProcessor [redoStack=" + redoStack.toString() + ", undoStack="
				+ undoStack.toString() + "]";
	}
	
}
