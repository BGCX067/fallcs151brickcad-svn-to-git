package modelviewcontroller;

import java.io.File;
import java.io.Serializable;
import java.util.Observable;

import momento.Momento;
import momento.Originator;
//import observable.Observable;
//test update comment
// test comment 2

/**
 * A class that creates a brick 
 */
public class Brick extends Observable 
	implements Originator, Momento, Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	// the height of the brick
	private double height;
	// the width of the brick
	private double width;
	// the length of the brick
	private double length;
	// the file to save and open
	private File file;
	private boolean changed = false;
	
	/**
	 * Constructs a brick with default values
	 */
	public Brick() {
		super();
		this.height = 20;
		this.width = 30;
		changed = false;
		this.length = 120;
	}

	@Override
	public void restoreFromMomento(Momento m)  {
		Brick b = (Brick) m;
		this.height = b.getHeight();
		this.length = b.getLength();
		this.width = b.getWidth();
		this.changed = false;
		setChanged();
		notifyObservers();
}

	@Override
	public Momento saveToMomento() {
		//System.out.println("Saving: " + this);
		return (Momento) this.clone();
	}

	/**
	 * gets the height of a brick
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * sets the height of a brick
	 * @param height the new height
	 */
	public void setHeight(double height) {
		
		this.height = (height <= 0) ? 1 : height;
		//System.out.println("Height = "  + height);
		changed = true;
		setChanged();
		notifyObservers();
	}
	
	public boolean isChanged()
	{
		return changed;
	}
	
	/**
	 * notifies observers of changes and sets changed flag to true
	 */
	public void seChanged()
	{
		changed = true;
		setChanged();
		notifyObservers();
	}
	
	public void setChanged(boolean t)
	{
		changed = t;
	}
	public void sChanged(boolean t)
	{
		changed = t;
	}
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = (width <= 0) ? 1 : width;
		//System.out.println("Width = "  + width);
		changed = true;
		setChanged();
		notifyObservers();
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = (length <= 0) ? 1 : length;
		//System.out.println("Length = "  + length);
		changed = true;
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return "Brick [height=" + height + ", length=" + length + ", width="
				+ width + ", " + "]";
	}

	public Object clone() {
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Brick newBrick = new Brick();
		newBrick.setHeight(this.getHeight());
		newBrick.setLength(this.getLength());
		newBrick.setWidth(this.getWidth());
		return newBrick;
	}

	public void set(double height, double length, double width) {
		setHeight(height);
		setWidth(width);
		setLength(length);
		changed = true;
		setChanged();
		notifyObservers();
	}

	/**
	 * gets the file
	 * @return
	 */
	public File getFile() {
		return file;
	}

	/**
	 * sets the file to a new one
	 * @param f the new file
	 */
	public void setFile(File f) {
		file = f;
		
	}
	
}
