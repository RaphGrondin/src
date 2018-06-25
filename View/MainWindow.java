package View;

import java.awt.Frame;

import javax.swing.*;

/**
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class MainWindow extends JFrame{
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public MainWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Drone simulation"); //$NON-NLS-1$
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
