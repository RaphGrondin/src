package Model;

import java.util.Random;

public class Package extends Element{
	private int value;
	private Vec destination;

	public Package(String name, int size) {
		super(name);
		this.setSize(size);
		Random rnd = new Random();
		int x = rnd.nextInt(GameManager.getWidth()-(int)getSize());
		int y = rnd.nextInt(GameManager.getHeight()-(int)getSize());
		this.setX(x+getSize()/2);
		this.setY(y+getSize()/2);
		int a = rnd.nextInt(GameManager.getWidth()-(int)getSize());
		int b = rnd.nextInt(GameManager.getHeight()-(int)getSize());
		this.destination.setX(a+getSize()/2);
		this.destination.setY(b+getSize()/2);
		this.setImage("src/Model/_img/package/package.png");
	}

	public Package(float x, float y, String name, int size, int value) {
		super(x,y,name,size);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Vec getDestination() {
		return destination;
	}

	public void setDestination(Vec destination) {
		this.destination = destination;
	}
}
