package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.GameManager;

public class Clock extends JPanel	{
	
	
	private static final long serialVersionUID = 1L;
	
	public Clock()
	{
		setPreferredSize(new Dimension(200, 30));
		
	}
	
	public void paintComponent(Graphics g){ 
		
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth()-1, this.getHeight());
	    Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white);  
	    g.drawString(GameManager.getTime().getH()+":"+(int)GameManager.getTime().getM(),75, 20);
	  
	  }
}
