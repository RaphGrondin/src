package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class BottomMenu extends JPanel implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	private AddItem pan1;
	private AddPackage pan2;
	private JTabbedPane tab;
	private Button bout = new Button ("Creer Animal");
	
	public BottomMenu()
	{
		setPreferredSize(new Dimension(1200, 100));
		bout.setPreferredSize(new Dimension(400,200));
		tab = new JTabbedPane();
		pan1 =new AddItem();
		pan2 =new AddPackage();
	    setBackground(Color.black);
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.white));
		setLayout(new BorderLayout());

		tab.addTab("Ajout de drone", pan1);
		tab.addTab("Ajout de colis", pan2);
		add(tab,BorderLayout.CENTER);
		/*add(pan1, BorderLayout.WEST);
		add(pan2, BorderLayout.CENTER);
		add(bout,BorderLayout.EAST);*/

		bout.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//new CreateDrone(null,"Creation d'un animal",true);
		
	}
}
