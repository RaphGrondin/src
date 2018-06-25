package View;

import java.awt.*;
import javax.swing.JPanel;

/** Implementation of the graphical interface regrouping the GameMananger view and the
 * menus displayed using the JPanel features.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class ViewPlateau extends JPanel{
	private static final long serialVersionUID = 1L;
	private static GameManagerView gmV;
	private static SideMenu ml;

	/** Getter for the GameManagerView.
	 *
	 * @return return the GameManagerView.
	 */
	public static GameManagerView getGmV() {
		return gmV;
	}

	/** Setter for the GameManagerView.
	 *
	 * @param gm GameManagerView to be set for the ViewPlateau.
	 */
	public static void setGmV(GameManagerView gm) {
		gmV = gm;
	}

	/** Getter for the SideMenu.
	 *
	 * @return return the SideMenu.
	 */
	public static SideMenu getMl() {
		return ml;
	}

	/** Setter for the SideMenu.
	 *
	 * @param _ml Side to be set for the ViewPlateau.
	 */
	public static void setMl(SideMenu _ml) {
		ml = _ml;
	}

	/** Loop that reprints the graphical interface to keep it up to date.
	 *
	 */
	public void go() {
		for(;;){

			this.repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/** Constructor for ViewPlateau. Defines the layouts of the components and adds them
	 * to the JPanel.
	 *
	 */
	@SuppressWarnings("hiding")
	public ViewPlateau() {
		setLayout(new BorderLayout());

		GameManagerView gmV = new GameManagerView();
		this.add(gmV, BorderLayout.CENTER);

		SideMenu ml = new SideMenu();
		this.add(ml,BorderLayout.WEST);

		BottomMenu mb = new BottomMenu();
		this.add(mb,BorderLayout.SOUTH);

		setGmV(gmV);
		setMl(ml);
	}

	@Override
	public void paintComponent(Graphics g) {
		gmV.repaint();
		ml.repaint();
	}


}
