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


public class SideMenu extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private static Clock H;
	private static GameManager gm;
	private static JComboBox<String> myList;

	
	public SideMenu(){
		setPreferredSize(new Dimension(200, 600));
		H=new Clock();
		Vector<String> names = new Vector<>();
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		JButton bouton = new JButton("Supprimer"); //$NON-NLS-1$
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
        /*ArrayList<String> dronesNames = gm.getDronesName();
        if (dronesNames == null) {
             names = new String[1];
             names[1] = "Aucun element";
        } else {
            names = new String[dronesNames.size()];
            names = dronesNames.toArray(names);
        }*/
		//String[] names = {"one"}; //$NON-NLS-1$
		setMyList(new JComboBox<>(names));
		getMyList().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vector<String> droneNames = new Vector<>();
				ArrayList<Drone> dronesList = GameManager.getDrones();
				if (dronesList.size() == 0) { droneNames.add("Aucun element"); //$NON-NLS-1$
				} else {
					for (Drone drone : drones) {
						droneNames.add(drone.getName());
					}
				}
				setMyList(new JComboBox<>(droneNames));
			}

		});
		add(H);
		add(text);
		add(getMyList());
		add(bouton);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white);

		g.drawString("Drones :"+GameManager.nbDrones(),25, 150);
	    g.drawString("Packages :"+GameManager.nbPackages(),25, 200);
	    g.drawString("Stations :"+GameManager.nbStations(),25, 250);
	    g.drawString("Items :"+GameManager.nbItems(),25, 300);
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
	
}
