package View;

import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewPlateau extends JPanel{
	private static GameManagerView gmV;
	private static SideMenu ml;
	
	public static GameManagerView getGmV() {
		return gmV;
	}

	public static void setGmV(GameManagerView gm) {
		gmV = gm;
	}

	public static SideMenu getMl() {
		return ml;
	}

	public static void setMl(SideMenu _ml) {
		ml = _ml;
	}
	
	public void go() {
		/*
		int x = getWidth();
		int y = getHeight();
		
		float XCoefficient = (float)x/GameManager.getLargeur();
		float YCoefficient = (float)y/GameManager.getHauteur();
		
		//GameManagerView.setCoefficientX(XCoefficient);
		//GameManagerView.setCoefficientY(YCoefficient);
		
		float coefficient;
        if (XCoefficient<YCoefficient)
            coefficient = XCoefficient;
        else
            coefficient = YCoefficient;
		
		GameManagerView.setCoefficientX(coefficient);
		GameManagerView.setCoefficientY(coefficient);
		*/
		
		for(;;){
			
			this.repaint();
			try {
		        Thread.sleep(16);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		}
	}

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
	
	public void paintComponent(Graphics g) {
		gmV.repaint();
		ml.repaint();
	}
	
	
}
