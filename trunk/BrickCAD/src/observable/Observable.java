package observable;

import java.util.LinkedList;

/*public class Observable implements Cloneable {
	private LinkedList<Observer> observers;
	private boolean changed;
	
	public Observable() {
		this.observers = new LinkedList<Observer>();
		this.changed = false;
	}
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	protected void notifyObservers() {
		if(!this.observers.isEmpty()) {
			for(Observer o : this.observers) {
				o.update();
			}
		}
	}
	
	public void setChanged() {
		this.changed = true;
	}
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	protected void setSaved() {
		this.changed = false;
	}
	
	public boolean isChanged() {return changed;}
	
	public String toString() {
		StringBuffer output = new StringBuffer("Observer [size=" + observers.size() + ", ");
		for(Observer o : observers) {
			output.append(o.toString() + ", ");
		}
		//clean up the last ", " make it look pretty
		output.delete(output.length() - 2, output.length());
		return output.append("]").toString();
	}
	
	public Object clone() {
		Observable newObject = new Observable();
		for(Observer o : observers) {
			newObject.addObserver(o);
		}
		if(this.changed != newObject.isChanged()) newObject.setChanged();
		return newObject;
	}
}
*/