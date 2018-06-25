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

    /** Multiplication operation between two vectors.
     *
     * @param v the vector to be multiplied to the calling vector.
     */
    void mult(Vec v) {
        x *= v.x;
        y *= v.y;
    }

    /** Computes the norm of the vector.
     *
     * @return the norm of the vector.
     */
    double mag() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    /** Computes the dot product between two vectors.
     *
     * @param v the vector used for the dot product.
     * @return the dot product between the calling vector and the parameter vector.
     */
    double dot(Vec v) {
        return x * v.x + y * v.y;
    }

    /** Normalizes the calling vector, transforming it in a unit vector.
     *
     */
    void normalize() {
        double mag = mag();
        if (mag != 0) {
            x /= mag;
            y /= mag;
        }
    }

    /** Limits the vector length (norm) to the defined limit norm.
     * This either changes nothing to the vector coordinates or makes them
     * smaller to match the required limit.
     *
     * @param lim the limit norm.
     */
    void limit(double lim) {
        double mag = mag();
        if (mag != 0 && mag > lim) {
            x *= lim / mag;
            y *= lim / mag;
        }
    }

    /** Computes the polar coordinates from the rectangular coordinates of the
     * vector and returns theta.
     *
     * @return return theta from polar coordinates (r, theta).
     */
    double heading() {
        return atan2(y, x);
    }

    /** Subtract two given vectors and return the result of the operation.
     *
     * @param v1 first vector of the operation.
     * @param v2 second vector of the operation.
     * @return return the vector result of the subtraction v1 - v2.
     */
    static Vec sub(Vec v1, Vec v2) {
        return new Vec(v1.x - v2.x, v1.y - v2.y);
    }

    /** Computes the distance between two vectors.
     *
     * @param v1 first vector of the operation.
     * @param v2 second vector of the operation.
     * @return return the distance between the two vectors as a double.
     */
    static double dist(Vec v1, Vec v2) {
        return sqrt(pow(v1.x - v2.x, 2) + pow(v1.y - v2.y, 2));
    }

    /** Computes the distance between the calling vector and the parameter vector.
     *
     * @param v the vector to compare for the distance.
     * @return return the distance between the two vectors as a double.
     */
    double dist(Vec v) {
        return sqrt(pow(x - v.x, 2) + pow(y - v.y, 2));
    }

    /** Computes the angle between two given vectors.
     *
     * @param v1 the first vector of the operation.
     * @param v2 the second vector of the operation.
     * @return the angle between both vectors as double.
     */
    static double angleBetween(Vec v1, Vec v2) {
        return acos(v1.dot(v2) / (v1.mag() * v2.mag()));
    }

    public void setX(double x) {
        this.x=x;
    }

    public void setY(double y) {
        this.y=y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


}