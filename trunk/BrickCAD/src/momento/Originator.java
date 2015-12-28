package momento;

public interface Originator {
	public Momento saveToMomento();
	public void restoreFromMomento(Momento m);
}
