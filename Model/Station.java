package Model;

import java.util.Random;

public class Station extends Element{
	private int droneCapacity;
	private int packageCapacity;

	public Station(int droneCapacity, int packageCapacity, int x, int y) {
		super();
		this.setSize(100);
		Random rnd = new Random();
		this.setX(x+getSize()/2);
		this.setY(y+getSize()/2);
		this.droneCapacity = droneCapacity;
		this.packageCapacity = packageCapacity;
		this.setImage("src/Model/_img/drone/helicopter.png");
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

}
