package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import Model.Drone;
import Model.GameManager;
import javax.swing.*;

/**
 *
 * @author Pierrick
 *
 */
public class SideMenu extends JPanel{


	private static final long serialVersionUID = 1L;
	private static Clock H;
	private static GameManager gm;
	private static JComboBox<String> myList;


	/**
	 *
	 */
	public SideMenu(){
		setPreferredSize(new Dimension(200, 600));
		H=new Clock();
		Vector<String> names = new Vector<>();
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		JButton bouton = new JButton("Supprimer"); //$NON-NLS-1$
		bouton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(getMyList().getItemCount()!=0){
					GameManager.removeDrone(getMyList().getSelectedItem().toString());
				}
			}
		});
		JLabel text = new JLabel("Selectionner un drone a supprimer"); //$NON-NLS-1$
		Font police = new Font("Courier", Font.BOLD,10); //$NON-NLS-1$
		text.setFont(police);
		text.setForeground(Color.white);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		ArrayList<Drone> drones = GameManager.getDrones();
		if (drones.size() == 0) { names.add("Aucun element"); //$NON-NLS-1$
		} else {
			for (Drone drone : drones) {
				names.add(drone.getName());
			}
		}
		setMyList(new JComboBox<>(names));
		add(H);
		add(text);
		add(getMyList());
		add(bouton);
	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20); //$NON-NLS-1$
		g.setFont(font);
		g.setColor(Color.white);

		g.drawString("Drones :"+GameManager.nbDrones(),25, 150); //$NON-NLS-1$
		g.drawString("Packages :"+GameManager.nbPackages(),25, 200); //$NON-NLS-1$
		g.drawString("Stations :"+GameManager.nbStations(),25, 250); //$NON-NLS-1$
		g.drawString("Items :"+GameManager.nbItems(),25, 300); //$NON-NLS-1$
	}


	/**
	 * @return
	 */
	public static JComboBox<String> getMyList() {
		return myList;
	}

	/**
	 * @param myList
	 */
	public static void setMyList(JComboBox<String> myList) {
		SideMenu.myList = myList;
	}

	/**
	 * @return
	 */
	public static GameManager getGm() {
		return gm;
	}

	/**
	 * @param gm
	 */
	public static void setGm(GameManager gm) {
		SideMenu.gm = gm;
	}

}
