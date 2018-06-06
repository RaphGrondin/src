package View;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
    public MainWindow() {
    	JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Vivarium");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setBackground(Color.black);
      
        ViewPlateau f = new ViewPlateau();
        this.setContentPane(f);
        
        this.setVisible(true);
        this.revalidate();
        this.repaint();
        
		// LANCEMENT DE LA VUE
		Thread v = new Thread(f::go);
		v.start();	
    }
}
