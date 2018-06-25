package Model;

import java.util.Random;

/** Implementation of the packages that will be grabbed and transported by the drones.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Package extends Element{
	private int value;

	/** Constructor of the Package which creates a package Element using random
	 * coordinates.
	 *
	 * @param name the name that identifies the package.
	 * @param size the size of the package (big/small).
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

	/** Constructor of the Package which creates a package Element using specified
	 * coordinates.
	 *
	 * @param x X coordinates of the package.
	 * @param y Y coordinates of the package.
	 * @param name the name that identifies the package.
	 * @param size the size of the package.
	 * @param value the scoring value of the package.
	 */
	public Package(float x, float y, String name, int size, int value) {
		super(x,y,name,size);
		this.value = value;
	}

	/** Getter for the value of the package.
	 *
	 * @return return the scoring value of the package.
	 */
	public int getValue() {
		return this.value;
	}

	/** Setter for the value of the package.
	 *
	 * @param value the set scoring value of the package.
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
