package Model;

import java.util.Random;

public class Item extends Element {

    private int value;

    public Item(String name) {
        super(name);
        this.setSize(50);
        Random rnd = new Random();
        int x = rnd.nextInt(GameManager.getWidth()-(int)getSize());
        int y = rnd.nextInt(GameManager.getHeight()-(int)getSize());
        this.setX(x+getSize()/2);
        this.setY(y+getSize()/2);
        this.setImage("src/Model/_img/item/flash.png");
    }

    public Item(float x, float y, String name, int size, int value) {
        super(x,y,name,size);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
