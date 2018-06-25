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

/**
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class AddStation extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private Button station = new Button("Station"); //$NON-NLS-1$
    private JLabel text = new JLabel("Add station"); //$NON-NLS-1$

    /**
     *
     */
    public AddStation()
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
        add(this.station, BorderLayout.NORTH);
        this.station.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }
}
