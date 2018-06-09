package Model;

public class Item extends Element {

    private int value;

    public Item(String name) {
        super(name);
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
