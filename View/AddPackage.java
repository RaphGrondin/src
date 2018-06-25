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

/**
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class AddPackage extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Button littlePackage = new Button("Little Package"); //$NON-NLS-1$
	private Button bigPackage = new Button("Big Package"); //$NON-NLS-1$
	private JLabel text = new JLabel("Add package"); //$NON-NLS-1$

	/**
	 *
	 */
	public AddPackage()
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
		add(this.littlePackage, BorderLayout.NORTH);
		add(this.bigPackage, BorderLayout.SOUTH);
		this.littlePackage.addActionListener(this);
		this.bigPackage.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.littlePackage){
			if (GameManager.nbPackages() < 10) {
				GameManager.addLittlePackage();
			}

		} else {
			if (GameManager.nbPackages() < 10) {
				GameManager.addBigPackage();
			}
		}

	}
}
