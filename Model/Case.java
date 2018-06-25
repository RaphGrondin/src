package Model;

/**
 *
 */
public class Case extends Element {
    private double width, height;

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Case(double x, double y, double width, double height) {
        super(x,y);
        this.width=width;
        this.height=height;
    }

    /**
     *
     * @return
     */
    public double getWidth() {
        return this.width;
    }

    /**
     *
     * @return
     */
    public double getHeight() {
        return this.height;
    }

}