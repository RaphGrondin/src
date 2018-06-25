package Model;

import java.util.ArrayList;

/** Implementation of the Board. Board is composed of multiple cases.
 *
 */
public class Board extends Element{
    private ArrayList<Case> cases;

    /** Constructor for Board. Sets the size of the Board to the size of the
     * GameManager and defines the number of cases to create.
     *
     * @author Pierrick GRAF
     * @author Raphaël GRONDIN
     */
    public Board() {
        this.cases = new ArrayList<>();
        int width = GameManager.getWidth();
        int height = GameManager.getHeight();
        int nbX = 12;
        int nbY = 10;
        for (int x=0; x<nbX; x++) {
            for (int y=0; y<nbY;y++) {
                Case c = new Case(x*(width/nbX),y*(height/nbY),(width/nbX),(height/nbY));
                this.cases.add(c);
            }
        }
    }

    /** Getter for the list of Cases.
     *
     * @return return the list of Cases composing the Board.
     */
    public ArrayList<Case> getCases() {
        return this.cases;
    }

}