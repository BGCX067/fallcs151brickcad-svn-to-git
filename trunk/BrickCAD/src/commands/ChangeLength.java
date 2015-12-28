package commands;
//test comment
import modelviewcontroller.Brick;

/*
 * a class that changes the length
 */
public class ChangeLength extends Command {
	
	// amt represents the value of the length
	private double amt;

	/**
	 * Constructs a ChangeLength
	 * @param theModel the model of the brick
	 */
	public ChangeLength(Brick theModel) {
		super(theModel);
	}

	/**
	 * Constructs a ChangeLength with a new value
	 * @param theModel the model of the brick
	 * @param amt the value of the length
	 */
	public ChangeLength(Brick theModel, double amt) {
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
		theModel.setLength(amt);
	}
}
