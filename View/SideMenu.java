package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Model.GameManager;

import javax.swing.*;


public class SideMenu extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private static Clock H;
	private static GameManager gm;

	
	public SideMenu(){
		setPreferredSize(new Dimension(200, 600));
	    H=new Clock();
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		JButton bouton = new JButton("Supprimer");
		JLabel text = new JLabel("Selectionner un drone a supprimer");
		Font police = new Font("Courier", Font.BOLD,10);
		text.setFont(police);
		text.setForeground(Color.white);
		text.setHorizontalAlignment(JLabel.CENTER);
		/*ArrayList<String> dronesNames = gm.getDronesName();
		if (dronesNames == null) {
			 names = new String[1];
			 names[1] = "Aucun element";
		} else {
			names = new String[dronesNames.size()];
			names = dronesNames.toArray(names);
		}*/
		String[] names = {"one"};
		JComboBox<String> myList = new JComboBox<>(names);
		add(H);
		add(text);
		add(myList);
		add(bouton);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white);

		g.drawString("Drones :"+GameManager.nbDrones(),25, 105);
	    g.drawString("Packages :"+GameManager.nbPackages(),25, 150);
	    g.drawString("Stations :"+GameManager.nbStations(),25, 200);
	    g.drawString("Items :"+GameManager.nbItems(),25, 250);
	}
	
	
}
