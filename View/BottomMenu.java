package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
public class BottomMenu extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;
	private AddDrone pan1;
	private AddPackage pan2;
	private AddItem pan3;
	private JTabbedPane tab;

	/**
	 *
	 */
	public BottomMenu()
	{
		setPreferredSize(new Dimension(1200, 100));
		this.tab = new JTabbedPane();
		this.pan1 =new AddDrone();
		this.pan2 =new AddPackage();
		this.pan3 = new AddItem();
		setBackground(Color.black);
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.white));
		setLayout(new BorderLayout());

		this.tab.addTab("Add drone", this.pan1); //$NON-NLS-1$
		this.tab.addTab("Add package", this.pan2); //$NON-NLS-1$
		this.tab.addTab("Add item", this.pan3); //$NON-NLS-1$
		add(this.tab,BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
