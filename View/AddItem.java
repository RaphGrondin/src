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

/** Implements the graphical interface using a JPanel for the creation of items
 * by the user.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 *
 */
public class AddItem extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Button item = new Button("Item"); //$NON-NLS-1$
	private JLabel text = new JLabel("Add item"); //$NON-NLS-1$

	/** Constructor for the AddItem. Sets a background color as well as the different
	 * buttons and displays needed.
	 *
	 */
	public AddItem()
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
		add(this.item, BorderLayout.NORTH);
		this.item.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.item) {
			if (GameManager.nbItems() < 10) {
				GameManager.addItem();
			}
		}
	}

}
