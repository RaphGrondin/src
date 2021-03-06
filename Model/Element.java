package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/** Abstract class of Element, defining the position, size and image of a given element.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public abstract class Element {
	protected Vec position;
	protected Vec acceleration;
	protected Vec speed;
	protected String name;
	protected int size;
	protected BufferedImage image;

	/** Default constructor of an Element.
	 *
	 */
	public Element() {
		Random rnd = new Random();

		int x = rnd.nextInt(GameManager.getWidth());
		int y = rnd.nextInt(GameManager.getHeight());

		this.image = null;
		this.name = "NULL"; //$NON-NLS-1$
		this.size = 0;
		this.position = new Vec(x,y);

	}

	/** Constructor of Element. Creates a default Element with a given name.
	 *
	 * @param name name of the Element to be created.
	 */
	public Element(String name) {
		this();
		this.name = name;
	}

	/** Constructor of Element. Creates an Element at a given location using coordinates,
	 * with a given name and of a given size.
	 *
	 * @param x X coordinate of the Element.
	 * @param y Y coordinate of the Element.
	 * @param name name of the Element.
	 * @param size size of the Element.
	 */
	public Element(double x, double y, String name, int size) {
		this();
		this.position = new Vec(x,y);
		this.name = name;
		this.size = size;
	}

	/** Constructor of Element. Creates a default Element at a given location using coordinates.
	 *
	 * @param x X coordinate of the Element.
	 * @param y Y coordinate of the Element.
	 */
	public Element (double x, double y) {
		this();
		this.position = new Vec(x,y);
		this.name = "Null"; //$NON-NLS-1$
		this.size = 0;
	}

	/** Getter of the X coordinate of the Position.
	 *
	 * @return return the X value of the coordinates of the Element.
	 */
	public double getX() {
		return this.position.getX();
	}

	/** Setter of the X coordinate of the Position.
	 *
	 * @param x the X coordinate to be set for the Element.
	 */
	public void setX(double x) {
		this.position.setX(x);
	}

	/** Getter of the Y coordinate of the Position.
	 *
	 * @return return the Y value of the coordinates of the Element.
	 */
	public double getY() {
		return this.position.getY();
	}

	/** Setter of the Y coordinate of the Position.
	 *
	 * @param y the Y coordinate to be set for the Element.
	 */
	public void setY(double y) {
		this.position.setY(y);
	}

	/** Getter for the name of the Element.
	 *
	 * @return return the name of the Element.
	 */
	public String getName() {
		return this.name;
	}

	/** Setter for the name of the Element.
	 *
	 * @param name the name to be set for the Element.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter for the size of the Element.
	 *
	 * @return return the size of the Element.
	 */
	public float getSize() {
		return this.size;
	}

	/** Setter for the size of the Element.
	 *
	 * @param size the size to be set for the Element.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/** Getter for the image of the Element.
	 *
	 * @return return the image of the Element.
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/** Setter for the path of the image for the Element.
	 *
	 * @param path the path of the image to be set for the Element.
	 */
	public void setImage(String path) {
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Getter for the acceleration of the Element.
	 *
	 * @return return the acceleration of the Element.
	 */
	public Vec getAcceleration() {
		return this.acceleration;
	}

	/** Setter for the acceleration of the Element.
	 *
	 * @param acceleration the acceleration to be set for the Element.
	 */
	public void setAcceleration(Vec acceleration) {
		this.acceleration = acceleration;
	}

	/** Getter for the speed of the Element.
	 *
	 * @return return the speed of the Element.
	 */
	public Vec getSpeed() {
		return this.speed;
	}

	/** Setter for the speed of the Element.
	 *
	 * @param speed the speed to be set for the Element.
	 */
	public void setSpeed(Vec speed) {
		this.speed = speed;
	}

	/** Getter for the position of the Element.
	 *
	 * @return return the position of the Element.
	 */
	public Vec getPosition() {
		return this.position;
	}

	/** Setter for the position of the Element.
	 *
	 * @param position the position to be set for the Element.
	 */
	public void setPosition(Vec position) {
		this.position = position;
	}
}
