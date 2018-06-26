package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import Model.*;
import Model.Package;

/** Implements the view of the GameManager, displaying the board and its contents
 * (Drones, Stations, Items, Packages).
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class GameManagerView extends JPanel{
	private static final long serialVersionUID = 1L;
	private static float coefficientX = 1;
	private static float coefficientY = 1;

	/** Default empty Constructor.
	 *
	 */
	public GameManagerView() {

	}

	/** Getter for the coefficient on X.
	 *
	 * @return return the coefficient on X.
	 */
	public static float getCoefficientX() {
		return coefficientX;
	}

	/** Setter for the coefficient on X.
	 *
	 * @param cx the coefficient on X to be set for the GameManagerView.
	 */
	public static void setCoefficientX(float cx) {
		coefficientX = cx;
	}

	/** Getter for the coefficient on Y.
	 *
	 * @return return the coefficient on Y.
	 */
	public static float getCoefficientY() {
		return coefficientY;
	}

	/** Setter for the coefficient on Y.
	 *
	 * @param cy the coefficient on Y to be set for the GameManagerView.
	 */
	public static void setCoefficientY(float cy) {
		coefficientY = cy;
	}

	/** Computes an integer ratio of the input depending on the coefficient on X.
	 *
	 * @param x the value to which the coefficient on X has to be multiplied.
	 * @return return the integer value of the input multiplied by the coefficient on X.
	 */
	public static int ratioX(double x){
		return (int)(x*getCoefficientX());
	}

	/** Computes an integer ratio of the input depending on the coefficient on Y.
	 *
	 * @param y the value to which the coefficient on Y has to be multiplied.
	 * @return return the integer value of the input multiplied by the coefficient on Y.
	 */
	public static int ratioY(double y){
		return (int)(y*getCoefficientY());
	}

	@Override
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
			g.drawImage(s.getImage(),ratioX(s.getX()-s.getSize()/2),ratioY(s.getY()-s.getSize()/2),(int)s.getSize(), (int)s.getSize(),this);
		}

		for (int i=0; i<GameManager.getDrones().size();i++){
			Drone d = GameManager.getDrones().get(i);
			g.drawImage(d.getImage(),ratioX(d.getX()-d.getSize()/2),ratioY(d.getY()-d.getSize()/2),(int)d.getSize(), (int)d.getSize(),this);
		}

		for (int i=0;i<GameManager.getPackages().size();i++) {
			Package p = GameManager.getPackages().get(i);
			g.setColor(new Color(0,255,0));
			g.drawImage(p.getImage(),ratioX(p.getX()-p.getSize()/2),ratioY(p.getY()-p.getSize()/2),(int)p.getSize(), (int)p.getSize(),this);
		}

		for (int i=0; i<GameManager.getItems().size();i++){
			Item it = GameManager.getItems().get(i);
			g.drawImage(it.getImage(),ratioX(it.getX()-it.getSize()/2),ratioY(it.getY()-it.getSize()/2),(int)it.getSize(), (int)it.getSize(),this);
		}

	}

}