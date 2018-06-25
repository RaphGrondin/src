package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 *
 */
public abstract class Element {
	protected Vec position;
	protected Vec acceleration;
	protected Vec speed;
	protected String name;
	protected int size;
	protected BufferedImage image;

	/**
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

	/**
	 *
	 * @param name
	 */
	public Element(String name) {
		this();
		this.name = name;
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @param name
	 * @param size
	 */
	public Element(double x, double y, String name, int size) {
		this();
		this.position = new Vec(x,y);
		this.name = name;
		this.size = size;
	}

	/**
	 *
	 * @param x
	 * @param y
	 */
	public Element (double x, double y) {
		this();
		this.position = new Vec(x,y);
		this.name = "Null"; //$NON-NLS-1$
		this.size = 0;
	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		return this.position.getX();
	}

	/**
	 *
	 * @param x
	 */
	public void setX(double x) {
		this.position.setX(x);
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		return this.position.getY();
	}

	/**
	 *
	 * @param y
	 */
	public void setY(double y) {
		this.position.setY(y);
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 */
	public float getSize() {
		return this.size;
	}

	/**
	 *
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 *
	 * @return
	 */
	public BufferedImage getImage() {
		return this.image;
	}

	/**
	 *
	 * @param path
	 */
	public void setImage(String path) {
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @return
	 */
	public Vec getAcceleration() {
		return this.acceleration;
	}

	/**
	 *
	 * @param acceleration
	 */
	public void setAcceleration(Vec acceleration) {
		this.acceleration = acceleration;
	}

	/**
	 *
	 * @return
	 */
	public Vec getSpeed() {
		return this.speed;
	}

	/**
	 *
	 * @param speed
	 */
	public void setSpeed(Vec speed) {
		this.speed = speed;
	}

	/**
	 *
	 * @return
	 */
	public Vec getPosition() {
		return this.position;
	}

	/**
	 *
	 * @param position
	 */
	public void setPosition(Vec position) {
		this.position = position;
	}
}
