package commands;

import modelviewcontroller.Brick;

/*
 * a class that changes the width
 */
public class ChangeWidth extends Command {
	
	// amt represents the value of the width
	private double amt;

	/**
	 * Constructs a ChangeWidth
	 * @param theModel the model of the brick
	 */
	public ChangeWidth(Brick theModel) {
		super(theModel);
	}
	
	/**
	 * Constructs a ChangeLength with a new value
	 * @param theModel the model of the brick
	 * @param amt the value of the length
	 */
	public ChangeWidth(Brick theModel, double amt) {
		super(theModel);
		this.amt = amt;
	}

	@Override
	public void execute() throws NegativeVector {
		momento = originator.saveToMomento();
		if(amt<=0) {
			throw new NegativeVector("Negative Value: " + amt +
					" - Positive Only");
		}
		theModel.setWidth(amt);
	}

}
