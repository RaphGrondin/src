package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Station extends Element{
	private int droneCapacity;
	private int packageCapacity;
	private BufferedImage image;
	
	public Station(int droneCapacity, int packageCapacity) {
		super();
		this.droneCapacity = droneCapacity;
		this.packageCapacity = packageCapacity;
		System.out.println("test");
		try {
			image = ImageIO.read(new File("C:\\Users\\rapha\\workspace\\GL52\\src\\Model\\_img\\drone\\helicopter.png"));
		} catch (IOException e) {}
	}
	
	public int getDroneCapacity() {
		return this.droneCapacity;
	}
	
	public void setDroneCapacity(int droneCapacity) {
		this.droneCapacity = droneCapacity;
	}
	
	public int getPackageCapacity() {
		return this.packageCapacity;
	}
	
	public void setPackageCapacity(int packageCapacity) {
		this.packageCapacity = packageCapacity;
	}

	public BufferedImage getImage() {
		return this.image;
	}
}
