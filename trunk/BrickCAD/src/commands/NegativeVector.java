package commands;

public class NegativeVector extends Throwable {
	private String msg;
	private static final long serialVersionUID = 1L;
	
	public NegativeVector(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}

}
