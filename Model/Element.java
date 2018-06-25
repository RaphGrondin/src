package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

public abstract class Element {
	protected Vec position;
	protected Vec acceleration;
	protected Vec speed;
	protected String name;
	protected int size;
	protected BufferedImage image;

	public Element() {
		Random rnd = new Random();

		int x = rnd.nextInt(GameManager.getWidth());
		int y = rnd.nextInt(GameManager.getHeight());

		this.image = null;
		this.name = "NULL";
		this.size = 0;
		this.position = new Vec(x,y);

	}

	public Element(String name) {
		this();
		this.name = name;
	}

	public Element(double x, double y, String name, int size) {
		this();
		this.position = new Vec(x,y);
		this.name = name;
		this.size = size;
	}

	public Element (double x, double y) {
		this();
		this.position = new Vec(x,y);
		this.name = "Null";
		this.size = 0;
	}

	public double getX() {
		return this.position.getX();
	}

	public void setX(double x) {
		this.position.setX(x);
	}

	public double getY() {
		return this.position.getY();
	}

	public void setY(double y) {
		this.position.setY(y);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {}
	}

	public Vec getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vec acceleration) {
		this.acceleration = acceleration;
	}

	public Vec getSpeed() {
		return speed;
	}

	public void setSpeed(Vec speed) {
		this.speed = speed;
	}

	public Vec getPosition() {
		return position;
	}

	public void setPosition(Vec position) {
		this.position = position;
	}
}
