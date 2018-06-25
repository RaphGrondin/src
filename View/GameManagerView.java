package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

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

		for (int i=0; i<GameManager.getStations().size();i++){
			Station s = GameManager.getStations().get(i);
			//g.drawImage(s.getImage(),(int)ratioX(0-s.getSize()/2),(int)ratioY(0-s.getSize()/2),(int)s.getSize(), (int)s.getSize(),this);
			g.drawImage(s.getImage(),ratioX(s.getX()-s.getSize()/2),ratioY(s.getY()-s.getSize()/2),(int)s.getSize(), (int)s.getSize(),this);
		}

		for (int i=0; i<GameManager.getDrones().size();i++){
			Drone d = GameManager.getDrones().get(i);
		    g.drawImage(d.getImage(),ratioX(d.getX()-d.getSize()/2),ratioY(d.getY()-d.getSize()/2),(int)d.getSize(), (int)d.getSize(),this);
			//this.add(d.getFuelProgress());
    	}
    	    	
    	for (int i=0;i<GameManager.getPackages().size();i++) {
    		Package p = GameManager.getPackages().get(i);
    		g.setColor(new Color(0,255,0));
			g.drawImage(p.getImage(),ratioX(p.getX()-p.getSize()/2),ratioY(p.getY()-p.getSize()/2),(int)p.getSize(), (int)p.getSize(),this);
    	}

		for (int i=0; i<GameManager.getItems().size();i++){
			Item it = GameManager.getItems().get(i);
			//g.drawImage(s.getImage(),(int)ratioX(0-s.getSize()/2),(int)ratioY(0-s.getSize()/2),(int)s.getSize(), (int)s.getSize(),this);
			g.drawImage(it.getImage(),ratioX(it.getX()-it.getSize()/2),ratioY(it.getY()-it.getSize()/2),(int)it.getSize(), (int)it.getSize(),this);
		}

	}

	public int getLargeur() {
		return getWidth();
	}
	public int getHauteur() {
		return getHeight();
	}

}