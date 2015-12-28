package commands;

import modelviewcontroller.Brick;

/*
 * a class that changes the height
 */
public class ChangeHeight extends Command {
	
	// amt represents the value of the height
	private double amt;

	/**
	 * Constructs a ChangeHieght
	 * @param theModel the model of the brick
	 */
	public ChangeHeight(Brick theModel) {
		super(theModel);
	}
	
	/**
	 * Constructs a ChangeHeight with a new value
	 * @param theModel the model of the brick
	 * @param amt the value of the height
	 */
	public ChangeHeight(Brick theModel, double amt) {
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
		theModel.setHeight(amt);
		
	}

}
