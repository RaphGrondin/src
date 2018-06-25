package Model;

/** Implementation of a Little drone, which is a Drone that can only pick up
 * Little Packages
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class LittleDrone extends Drone {

	/** Constructor of a LittleDrone. The constructor is using the Drone constructor
	 * but with a set size.
	 *
	 * @param name name of the drone.
	 */
	public LittleDrone(String name) {
		super(name,50);
	}

}
