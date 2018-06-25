package View;

import java.awt.Frame;

import javax.swing.*;

/** Implements the Main Window of the Application in which the Panels will be displayed.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class MainWindow extends JFrame{
    private static final long serialVersionUID = 1L;

    /** Constructor of MainWindow. Creates the main window of the application, which contains
     * the ViewPlateau.
     */
    public MainWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setTitle("Drone simulation"); //$NON-NLS-1$
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
