package observable;

import momento.Momento;

public interface Originator {
	public Momento saveToMomento();
	public void restoreFromMomento(Momento m);
}
