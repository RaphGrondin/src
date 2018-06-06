package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import Model.Animal;
import Model.Case;
import Model.GameManager;
import Model.Nourriture;

@SuppressWarnings("serial")
public class GameManagerView extends JPanel{
	private static float coefficientX = 1;
	private static float coefficientY = 1;
	public GameManagerView() {

	}

	public static float getCoefficientX() {
		return coefficientX;
	}

	public static void setCoefficientX(float cx) {
		coefficientX = cx;
	}

	public static float getCoefficientY() {
		return coefficientY;
	}

	public static void setCoefficientY(float cy) {
		coefficientY = cy;
	}
	
    public static int ratioX(double x){
        return (int)(x*getCoefficientX());
    }
    public static int ratioY(double y){
        return (int)(y*getCoefficientY());
    }
    
	public void paintComponent(Graphics g) {		
		g.setColor(new Color(0,200,0));
		g.fillRect(0,0,getWidth(),getHeight());
    	for (Case c : GameManager.getPlateau().getCases()) {    				
        	if (c.isAquatique()){ 
        		g.setColor(new Color(176,224,230));
        	} else {
        		g.setColor(new Color(208,192,122));
        	} 
        	
    	    g.fillRect(ratioX(c.getPosition().getX()), ratioY(c.getPosition().getY()), ratioX(c.getLargeur()), ratioY(c.getHauteur()));
    	    g.setColor(new Color(0,0,0));
    	    g.drawRect(ratioX(c.getPosition().getX()), ratioY(c.getPosition().getY()), ratioX(c.getLargeur()), ratioY(c.getHauteur())); 
    	} 
		
		for (int i=0; i<GameManager.getAnimaux().size();i++){
			Animal ai = GameManager.getAnimaux().get(i);
			
			g.setColor(ai.getCouleur());
		    g.fillOval(ratioX(ai.getPosition().getX()),ratioY(ai.getPosition().getY()), ratioX(ai.getCaracVitale().getTaille()), ratioY(ai.getCaracVitale().getTaille()));    	
    	}
    	    	
    	for (int i=0;i<GameManager.getNourritures().size();i++) {
    		Nourriture n = GameManager.getNourritures().get(i);
        	if (n.isPlante()) {
        		g.setColor(Color.green);
        	} else {
        		g.setColor(Color.red);
        	}
        	g.fillRect(ratioX(n.getPosition().getX()-10), ratioY(n.getPosition().getY()-10), ratioX(20), ratioY(20));
    	}
	}

	public int getLargeur() {
		return getWidth();
	}
	public int getHauteur() {
		return getHeight();
	}

	
	

}