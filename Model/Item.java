package Model;

import java.util.Random;

/** Implementation of items that enhance the performance of the drones using them.
 * (currently not implemented to be used).
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Item extends Element {

    private int value;

    /** Constructor of the Item which creates an item Element using random
     * coordinates.
     *
     * @param name name of the Item.
     */
    public Item(String name) {
        super(name);
        this.setSize(50);
        Random rnd = new Random();
        int x = rnd.nextInt(GameManager.getWidth()-(int)getSize());
        int y = rnd.nextInt(GameManager.getHeight()-(int)getSize());
        this.setX(x+getSize()/2);
        this.setY(y+getSize()/2);
        this.setImage("src/Model/_img/item/flash.png"); //$NON-NLS-1$
    }

    /** Constructor of the Item which creates an item Element using specified
	 * coordinates.
     *
     * @param x X coordinates of the item.
     * @param y Y coordinates of the item.
     * @param name the name that identifies the item.
     * @param size the size of the item.
     * @param value the scoring value of the item.
     */
    public Item(float x, float y, String name, int size, int value) {
        super(x,y,name,size);
        this.value = value;
    }

    /** Getter of the scoring value of the item.
     *
     * @return return the scoring value of the item.
     */
    public int getValue() {
        return this.value;
    }

    /** Setter of the scoring value of the item.
     *
     * @param value the scoring value of the item.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
