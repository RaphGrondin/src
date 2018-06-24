package Model;

public class Station extends Element{
	private int droneCapacity;
	private int packageCapacity;
	
	public Station(int droneCapacity, int packageCapacity) {
		super();
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
