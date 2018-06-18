package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drone extends Element {
	private float fuel;
	private int score;
	private BufferedImage image;

	public Drone(String name, int size) {
		super(name);
		this.setSize(size);
		try {
			image = ImageIO.read(new File("C:\\Users\\rapha\\workspace\\GL52\\src\\_img\\drone\\albatross.png"));
		} catch (IOException e) {}

		this.fuel = 100;
		this.score = 0;
	}

	public Drone(float x, float y, String name, int size, float fuel, int score) {
		super(x,y,name,size);
		try {
			image = ImageIO.read(new File("C:\\Users\\rapha\\workspace\\GL52\\src\\_img\\drone\\albatross.png"));
		} catch (IOException e) {}
		this.fuel = fuel;
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public float getFuel() {
		return this.fuel;
	}
	
	public void setFuel(float fuel) {
		this.fuel = fuel;
	}

	public BufferedImage getImage() {
		return this.image;
	}
}
