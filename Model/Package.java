package Model;

public class Package extends Element{
	private int value;
	
	public Package(int value) {
		super();
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
