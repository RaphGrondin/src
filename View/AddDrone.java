package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.GameManager;

/** Implements the graphical interface using a JPanel for the creation of drones
 * by the user.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 *
 */
public class AddDrone extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private Button littleDrone = new Button("Little Drone"); //$NON-NLS-1$
    private Button bigDrone = new Button("Big Drone"); //$NON-NLS-1$
    private JLabel text = new JLabel("Add drone"); //$NON-NLS-1$

    /** Constructor for the AddDrone. Sets a background color as well as the different
     * buttons and displays needed.
     *
     */
    public AddDrone()
    {
        setBackground(Color.black);
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
        setPreferredSize(new Dimension(400, 200));
        Font police = new Font("Courier", Font.BOLD, 20); //$NON-NLS-1$

        this.text.setFont(police);
        this.text.setForeground(Color.white);
        this.text.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(this.text, BorderLayout.CENTER);
        add(this.littleDrone, BorderLayout.NORTH);
        add(this.bigDrone, BorderLayout.SOUTH);
        this.littleDrone.addActionListener(this);
        this.bigDrone.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {


        if(arg0.getSource() == this.littleDrone){
            if (GameManager.nbDrones() < 10) {
                GameManager.addLittleDrone();
            }

        } else {
            if (GameManager.nbDrones() < 10) {
                GameManager.addBigDrone();
            }
        }

    }

}
