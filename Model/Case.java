package Model;

/** Implements a rectangle case that defines a space of the board.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Case extends Element {
    private double width, height;

    /** Constructor of Case. Creates a Case depending on the coordinates and size.
     *
     * @param x X coordinates to be set for the Case.
     * @param y Y coordinates to be set for the Case.
     * @param width width to be set for the Case.
     * @param height height to be set for the Case.
     */
    public Case(double x, double y, double width, double height) {
        super(x,y);
        this.width=width;
        this.height=height;
    }

    /** Getter for the width of the Case.
     *
     * @return return the width of the Case.
     */
    public double getWidth() {
        return this.width;
    }

    /** Getter for the hight of the Case.
     *
     * @return return the height of the Case.
     */
    public double getHeight() {
        return this.height;
    }

}