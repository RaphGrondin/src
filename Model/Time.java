
package Model;

/** Implementation of the class tracking the time.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Time {

    private int hours;
    private double minutes;

    /** Constructor of the Time class.
     * Values of hours and minutes are initialized at 0 so that the starting
     * time is midnight.
     */
    public Time()
    {
        this.hours=0;
        this.minutes=0;
    }

    /** Method that sets the time change as a 24 hour clock.
     * Each time the method is called, the minutes are incremented by 0.5.     *
     */
    public void running()
    {
        this.minutes+=0.5;
        if(this.minutes >= 60)
        {
            this.minutes=0;
            this.hours++;
        }
        if( this.hours >=24)
        {
            this.hours=0;
        }

    }

    /** Getter for the hours value of the Time.
     *
     * @return return the current hours value.
     */
    public int getH()
    {
        return this.hours;
    }

    /** Getter of the minutes value of the Time.
     *
     * @return return the current minutes value.
     */
    public double getM()
    {
        return this.minutes;
    }

    /** Setter for the hours variable.
     *
     * @param hours value of the hours that will be set.
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /** Setter for the minutes variable.
     *
     * @param minutes value of the minutes that will be set.
     */
    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }
}

