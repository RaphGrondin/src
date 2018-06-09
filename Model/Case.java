package Model;

import java.util.Random;

public class Case extends Element {
    private double width, height;

    public Case(double x, double y, double width, double height) {
        super(x,y);
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

}