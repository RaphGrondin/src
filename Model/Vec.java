package Model;


import static java.lang.Math.acos;
import static java.lang.Math.atan2;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/** Implementation of a two dimensional vector.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Vec {
    private double x, y;

    /** Empty constructor of the vector.
     *
     */
    public Vec() {
    }

    /** Construct a vector with coordinates.
     *
     * @param x the X coordinate of the vector.
     * @param y the Y coordinate of the vector.
     */
    public Vec(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Addition operation between two vectors.
     *
     * @param v the vector to be added to the calling vector.
     */
    void add(Vec v) {
        x += v.x;
        y += v.y;
    }

    /** Subtraction operation between two vectors.
     *
     * @param v the vector to be subtracted to the calling vector.
     */
    void sub(Vec v) {
        x -= v.x;
        y -= v.y;
    }

    /** Divide the vector coordinates with a real number.
     *
     * @param val real number to be divided to the coordinates.
     */
    void div(double val) {
        x /= val;
        y /= val;
    }

    /** Multiply the vector coordinates with a real number.
     *
     * @param val real number to multiply to the coordinates.
     */
    void mult(double val) {
        x *= val;
        y *= val;
    }

    /** Multiply each vector coordinate with a different real number.
     *
     * @param abs real number to multiply the X coordinate.
     * @param ord real number to multiply the Y coordinate.
     */
    void mult(double abs,double ord) {
        x *= abs;
        y *= ord;
    }

    
    void mult(Vec v) {
        x *= v.x;
        y *= v.y;
    }
    double mag() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    double dot(Vec v) {
        return x * v.x + y * v.y;
    }

    void normalize() {
        double mag = mag();
        if (mag != 0) {
            x /= mag;
            y /= mag;
        }
    }

    void limit(double lim) {
        double mag = mag();
        if (mag != 0 && mag > lim) {
            x *= lim / mag;
            y *= lim / mag;
        }
    }

    double heading() {
        return atan2(y, x);
    }

    static Vec sub(Vec v, Vec v2) {
        return new Vec(v.x - v2.x, v.y - v2.y);
    }

    static double dist(Vec v, Vec v2) {
        return sqrt(pow(v.x - v2.x, 2) + pow(v.y - v2.y, 2));
    }
    double dist(Vec v) {
        return sqrt(pow(x - v.x, 2) + pow(y - v.y, 2));
    }

    static double angleBetween(Vec v, Vec v2) {
        return acos(v.dot(v2) / (v.mag() * v2.mag()));
    }

    public void setX(double x) {
        this.x=x;
    }

    public void setY(double y) {
        this.y=y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }


}