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
		JButton bouton = new JButton();
		String[] names;
		ArrayList<String> dronesNames = gm.getDronesName();
		if (dronesNames == null) {
			 names = new String[1];
			 names[1] = "Aucun element";
		} else {
			names = new String[dronesNames.size()];
			names = dronesNames.toArray(names);
		}

		JComboBox<String> myList = new JComboBox<>(names);
		add(H);
		add(myList);
		add(bouton);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth()-1, this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white);


		/*ListModel<String> model = myList.getModel();
		for(int i = 0; i < model.getSize(); i++) {
			System.out.println(model.getElementAt(i));
		}*/

		//g.drawString("Carnivores :"+GameManager.nbCarnivores(),25, 150);
	    /*g.drawString("Animaux :"+GameManager.nbAnimaux(),50, 100);
	    g.drawString("Carnivores :"+GameManager.nbCarnivores(),25, 150);
	    g.drawString("Herbivores :"+GameManager.nbHerbivores(),25, 200);
	    g.drawString("Nourritures:"+GameManager.nbNourritures(),25, 250);
	    g.drawString("Viandes :"+GameManager.nbViandes(),50, 300);
	    g.drawString("Herbes :"+GameManager.nbHerbes(),60, 350);*/
	}
	
	
}
