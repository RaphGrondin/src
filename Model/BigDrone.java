package Model;

/** Implementation of a Big drone, which is a Drone that can pick up any packages.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class BigDrone extends Drone{

	/** Constructor of a BigDrone. The constructor is using the Drone constructor
	 * but with a set size.
	 *
	 * @param name name of the drone.
	 */
	public BigDrone(String name) {
		super(name,100);
	}


}
