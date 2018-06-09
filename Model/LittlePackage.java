package Model;

public class LittlePackage extends Package{

	public LittlePackage(String name) {
		super(name);
		this.setValue(50);
	}

	public LittlePackage(float x, float y, String name, int size) {
		super(x, y, name, size, 50);
		// TODO Auto-generated constructor stub
	}

}
