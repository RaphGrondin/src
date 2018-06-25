package Model;

import java.util.Random;

/** Implementation of the packages that will be grabbed and transported by the drones.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Package extends Element{
	private int value;

	/** 
	 *
	 * @param name
	 * @param size
	 */
	public Package(String name, int size) {
		super(name);
		this.setSize(size);
		Random rnd = new Random();
		int x = rnd.nextInt(GameManager.getWidth()-(int)getSize());
		int y = rnd.nextInt(GameManager.getHeight()-(int)getSize());
		this.setX(x+getSize()/2);
		this.setY(y+getSize()/2);
		this.setImage("src/Model/_img/package/package.png"); //$NON-NLS-1$
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @param name
	 * @param size
	 * @param value
	 */
	public Package(float x, float y, String name, int size, int value) {
		super(x,y,name,size);
		this.value = value;
	}

	/**
	 *
	 * @return
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 *
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
