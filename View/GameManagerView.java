package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import Model.*;
import Model.Package;

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
		g.setColor(new Color(255,255,255));
		g.fillRect(0,0,getWidth(),getHeight());
    	for (Case c : GameManager.getBoard().getCases()) {
			g.setColor(new Color(255,255,255));
			g.fillRect(ratioX(c.getX()), ratioY(c.getY()), ratioX(c.getWidth()), ratioY(c.getHeight()));
			g.setColor(new Color(0,0,0));
    	    g.drawRect(ratioX(c.getX()), ratioY(c.getY()), ratioX(c.getWidth()), ratioY(c.getHeight()));
    	} 
		
		for (int i=0; i<GameManager.getDrones().size();i++){
			Drone d = GameManager.getDrones().get(i);
			//g.setColor(new Color (255,0,0));
		    //g.fillOval(ratioX(d.getX()),ratioY(d.getY()), ratioX(d.getSize()), ratioY(d.getSize()));
		    g.drawImage(d.getImage(),(int)ratioX(d.getX()),(int)ratioY(d.getY()),(int)d.getSize(), (int)d.getSize(),this);
    	}
    	    	
    	for (int i=0;i<GameManager.getPackages().size();i++) {
    		Package p = GameManager.getPackages().get(i);
    		g.setColor(new Color(0,255,0));
        	g.fillRect(ratioX(p.getX()-10), ratioY(p.getY()-10), ratioX(20), ratioY(20));
    	}

		for (int i=0; i<GameManager.getStations().size();i++){
			Station s = GameManager.getStations().get(i);
			//g.setColor(new Color (255,0,0));
			//g.fillOval(ratioX(d.getX()),ratioY(d.getY()), ratioX(d.getSize()), ratioY(d.getSize()));
			g.drawImage(s.getImage(),(int)ratioX(s.getX()),(int)ratioY(s.getY()),(int)s.getSize(), (int)s.getSize(),this);
		}
	}

	public int getLargeur() {
		return getWidth();
	}
	public int getHauteur() {
		return getHeight();
	}

}