package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Button extends JButton implements MouseListener {

	
	private static final long serialVersionUID = 1L;
	private String name;
	private Color c1,c2;
	
	  public Button(String str){
	    super(str);
	    this.name = str;
	    c1=Color.black;
	    c2=Color.white;
	    addMouseListener(this);
	    
	  }

	        

	  public void paintComponent(Graphics g){

		g.setColor(c1);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(c2);
	    g.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);

	  }



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		c1=Color.white;
		c2=Color.black;
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		c1=Color.black;
		c2=Color.white;
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}  
	

	  
	  
}