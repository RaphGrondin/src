package Model;

import java.util.ArrayList;

/**
 *
 */
public class Board extends Element{
    private ArrayList<Case> cases;

    /**
     *
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

    /**
     *
     * @return
     */
    public ArrayList<Case> getCases() {
        return this.cases;
    }

}