package commands;

import modelviewcontroller.Brick;
import momento.*;

public abstract class Command {
	protected Originator originator;
	protected Momento momento;
	protected Brick theModel;
	
	public Command(Brick theModel) {
		this.theModel = theModel;
		this.originator = (Originator) theModel;
	}
	
	public abstract void execute() throws NegativeVector;
	
	public void undo() {
		//SO before we undo the command we need to make a momento of
		//the model BEFORE we undo it, so we can redo it if we want later
		Momento tempM = originator.saveToMomento();
		originator.restoreFromMomento(momento);
		momento = tempM;
	}

	@Override
	public String toString() {
		return "Command [momento=" + momento + ", theModel=" + theModel + "]";
	}
	
	
	
	
}
