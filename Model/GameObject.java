package Model;

import java.util.Random;

public abstract class GameObject {
    protected Vec position;
    protected int width, height;

    public GameObject() {
        Random rnd = new Random();

        int x = rnd.nextInt(GameManager.getLargeur());
        int y = rnd.nextInt(GameManager.getHauteur());

        position = new Vec(x, y);
    }

    public GameObject(double x, double y) {
        position = new Vec(x, y);
    }

    public Vec getPosition() {
        return position;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

