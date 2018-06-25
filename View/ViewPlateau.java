package View;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class ViewPlateau extends JPanel{
	private static final long serialVersionUID = 1L;
	private static GameManagerView gmV;
	private static SideMenu ml;

	/**
	 * @return
	 */
	public static GameManagerView getGmV() {
		return gmV;
	}

	/**
	 * @param gm
	 */
	public static void setGmV(GameManagerView gm) {
		gmV = gm;
	}

	/**
	 * @return
	 */
	public static SideMenu getMl() {
		return ml;
	}

	/**
	 * @param _ml
	 */
	public static void setMl(SideMenu _ml) {
		ml = _ml;
	}

	/**
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

	/**
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
