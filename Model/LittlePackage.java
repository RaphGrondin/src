package Model;

/** Implementation of a Little package, which is a package that can be picked up by
 * Little Drones and Big Drones.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class LittlePackage extends Package{

	/** Constructor of a LittlePackage. The constructor is using the Package constructor
	 * but with a set size and value.
	 *
	 * @param name name of the package.
	 */
	public LittlePackage(String name) {
		super(name, 25);
		this.setValue(50);
	}

}
