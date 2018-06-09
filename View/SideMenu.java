package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.GameManager;

public class SideMenu extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private static Clock H;
	
	
	public SideMenu(){
		setPreferredSize(new Dimension(200, 600));
	    H=new Clock();
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		add(H);	
	}
	
	/*public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth()-1, this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white); 
	    g.drawString("Animaux :"+GameManager.nbAnimaux(),50, 100);
	    g.drawString("Carnivores :"+GameManager.nbCarnivores(),25, 150);
	    g.drawString("Herbivores :"+GameManager.nbHerbivores(),25, 200);
	    g.drawString("Nourritures:"+GameManager.nbNourritures(),25, 250);
	    g.drawString("Viandes :"+GameManager.nbViandes(),50, 300);
	    g.drawString("Herbes :"+GameManager.nbHerbes(),60, 350);    
	}*/
	
	
}
