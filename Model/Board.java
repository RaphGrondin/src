package Model;

import java.util.ArrayList;

public class Board extends Element{
    private static ArrayList<Case> cases;

    public Board() {
        cases = new ArrayList<Case>();

        int width = GameManager.getWidth();
        int height = GameManager.getHeight();
        int nbX = 12;
        int nbY = 10;
        for (int x=0; x<nbX; x++) {
            for (int y=0; y<nbY;y++) {
                Case c = new Case(x*(width/nbX),y*(height/nbY),(width/nbX),(height/nbY));
                cases.add(c);
            }
        }
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

}