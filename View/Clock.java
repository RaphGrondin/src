package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.GameManager;

/** Implements the visual of the Clock using the Time class to create a display of the time.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class Clock extends JPanel	{


	private static final long serialVersionUID = 1L;

	/** Constructor for the Clock. Defines the dimensions for the clock.
	 *
	 */
	public Clock()
	{
		setPreferredSize(new Dimension(200, 30));

	}

	@Override
	public void paintComponent(Graphics g){

		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth()-1, this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20); //$NON-NLS-1$
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(GameManager.getTime().getH()+":"+(int)GameManager.getTime().getM(),75, 20); //$NON-NLS-1$

	}
}
