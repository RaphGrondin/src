package Model;

/** Implementation of a Big package, which is a package that can only be picked up by Big Drones.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class BigPackage extends Package{

    /** Constructor of a BigPackage. The constructor is using the Package constructor
     * but with a set size and value.
     *
     * @param name name of the package.
     */
    public BigPackage(String name) {
        super(name, 50);
        this.setValue(100);
    }
}
