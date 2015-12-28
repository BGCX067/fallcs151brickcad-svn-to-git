package observable;

public class TestObserver implements Observer{
	public String name;
	
	public TestObserver(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "TestObserver [name=" + name + "]";
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
