
package Model;

public class Time {

    private int hours;
    private double minutes;

    public Time()
    {
        hours=8;
        minutes=1;
    }

    public void running()
    {
        minutes+=0.5;
        if(minutes >= 60)
        {
            minutes=0;
            hours++;
        }
        if( hours >=24)
        {
            hours=0;
        }

    }
    public int getH()
    {
        return hours;
    }
    public double getM()
    {
        return minutes;
    }

    public Time getTmp()
    {
        return this;
    }
    public void setTmp()
    {
        this.running();
    }
}

