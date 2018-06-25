package Model;

/** Implementation of the station where the drones can dock and drop packages.
 * Drones can refuel at a station.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Station extends Element{
	private int droneCapacity;
	private int packageCapacity;

	/** Constructor of the Station which creates a station Element.
	 *
	 * @param droneCapacity capacity of drones the station can contain simultaneously.
	 * @param packageCapacity capacity of packages the station can contain simultaneously.
	 * @param x X coordinates of the station.
	 * @param y Y coordinates of the station.
	 */
	public Station(int droneCapacity, int packageCapacity, int x, int y) {
		super();
		this.setSize(100);
		this.setX(x+getSize()/2);
		this.setY(y+getSize()/2);
		this.droneCapacity = droneCapacity;
		this.packageCapacity = packageCapacity;
		this.setImage("src/Model/_img/drone/helicopter.png"); //$NON-NLS-1$
	}

	/** Getter of the droneCapacity variable.
	 *
	 * @return return the amount of drones that the Station can contain simultaneously.
	 */
	public int getDroneCapacity() {
		return this.droneCapacity;
	}

	/** Setter of the droneCapacity variable.
	 *
	 * @param droneCapacity the amount of drones that the Station will be available to contain.
	 */
	public void setDroneCapacity(int droneCapacity) {
		this.droneCapacity = droneCapacity;
	}

	/** Getter of the packageCapacity variable.
	 *
	 * @return return the amount of packages that the Station can contain simultaneously.
	 */
	public int getPackageCapacity() {
		return this.packageCapacity;
	}

	/** Setter of the packageCapacity variable.
	 *
	 * @param packageCapacity the amount of packages that the Station will be available to contain.
	 */
	public void setPackageCapacity(int packageCapacity) {
		this.packageCapacity = packageCapacity;
	}

}
